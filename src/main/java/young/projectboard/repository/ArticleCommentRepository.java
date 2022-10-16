package young.projectboard.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import young.projectboard.domain.Article;
import young.projectboard.domain.ArticleComment;
import young.projectboard.domain.QArticle;
import young.projectboard.domain.QArticleComment;

import java.util.List;

@RepositoryRestResource // spring data rest 사용하기 위한 annotation
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,

        QuerydslPredicateExecutor<ArticleComment>, // 모든 필드에 검색기능 추가
        QuerydslBinderCustomizer<QArticleComment> {

        @Override
        default void customize(QuerydslBindings bindings, QArticleComment root) {
            bindings.excludeUnlistedProperties(true);
            bindings.including(root.content, root.createdAt, root.createdBy);
            bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
            bindings.bind(root.createdAt).first(DateTimeExpression::eq);
            bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }

}
