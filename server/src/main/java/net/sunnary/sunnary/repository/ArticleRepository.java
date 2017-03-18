package net.sunnary.sunnary.repository;

import net.sunnary.sunnary.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a FETCH ALL PROPERTIES")
    List<Article> findAllFetchEager();
}
