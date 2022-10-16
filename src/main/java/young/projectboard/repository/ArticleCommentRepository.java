package young.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import young.projectboard.domain.ArticleComment;

@RepositoryRestResource // spring data rest 사용하기 위한 annotation
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {

}
