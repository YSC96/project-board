package young.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import young.projectboard.domain.ArticleComment;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
