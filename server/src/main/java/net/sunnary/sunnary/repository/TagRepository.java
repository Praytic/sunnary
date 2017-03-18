package net.sunnary.sunnary.repository;

import net.sunnary.sunnary.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
