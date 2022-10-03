package young.projectboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList =  "content"),
        @Index(columnList =  "createdAt"),
        @Index(columnList =  "createdBy")
})
@Entity
public class ArticleComment extends AuditingFields{

    @Id // PK
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // 자동 증가
    private Long id;

    @Setter @ManyToOne(optional = false) private Article article; // 게시글 (ID) , article id 가져오기 위해
    @Setter @Column(nullable = false, length = 500) private String content; // 본문

    protected ArticleComment() {}

    private ArticleComment(Article article, String content) {
        this.article = article;
        this.content = content;
    }

    public static ArticleComment of(Article article, String content) {
        return new ArticleComment(article, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        ArticleComment that = (ArticleComment) o;
        return id != null && id.equals(that.id); // id가 null이 아닌 경우 && id같은지 비교
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
