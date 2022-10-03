package young.projectboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList =  "title"),
        @Index(columnList =  "hashtag"),
        @Index(columnList =  "createdAt"),
        @Index(columnList =  "createdBy")
})
@Entity
public class Article extends AuditingFields{
    @Id // PK
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // 자동 증가
    private Long id;


    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문

    @Setter private String hashtag; // 해시태그

    // 양방향 바인딩
    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) // article 테이블로부터 온, 글삭제하면 댓글도 삭제되도록 cascade all
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>(); // 중복허용 x


    protected  Article() {} // 기본생성자

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) { // 의도
        return  new Article(title, content, hashtag);
    }

    // list에 넣을때 중복요소제거, 정렬 할때 비교를 해야하므로 동등성 검사
    // (lombok = @EqualsAndHashCode) 는 모든필드를 검사하므로 equals() and hashCode() 를 이용하여 id만 검사
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return id != null && id.equals(article.id); // id가 null이 아닌 경우 && id같은지 비교
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
