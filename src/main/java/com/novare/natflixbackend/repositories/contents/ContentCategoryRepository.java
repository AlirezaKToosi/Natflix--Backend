package com.novare.natflixbackend.repositories.contents;

import com.novare.natflixbackend.models.contents.ContentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentCategoryRepository extends JpaRepository<ContentCategory, Integer> {
}
