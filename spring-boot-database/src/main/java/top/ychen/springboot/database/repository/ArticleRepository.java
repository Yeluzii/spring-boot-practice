package top.ychen.springboot.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.ychen.springboot.database.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
//    Article findByAuthor(String author);
}
