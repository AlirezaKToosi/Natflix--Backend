package com.novare.natflixbackend.repositories.contents;


import com.novare.natflixbackend.models.contents.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentTypeRepository extends JpaRepository<ContentType, Integer> {
}
