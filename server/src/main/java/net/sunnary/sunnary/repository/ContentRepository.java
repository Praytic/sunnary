package net.sunnary.sunnary.repository;

import net.sunnary.sunnary.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    @Query("SELECT a FROM Content a FETCH ALL PROPERTIES")
    List<Content> findAllFetchEager();
}
