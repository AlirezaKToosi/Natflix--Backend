package com.novare.natflixbackend.repositories.contents;

import com.novare.natflixbackend.models.contents.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {
}
