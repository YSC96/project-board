package young.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import young.projectboard.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}