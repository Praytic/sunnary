package net.sunnary.sunnary.repository;

import net.sunnary.sunnary.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, String> {

    @Query("SELECT tag FROM Tag tag WHERE tag LIKE CONCAT(?1, '%')")
    List<Tag> getByQuery(String query);
}
