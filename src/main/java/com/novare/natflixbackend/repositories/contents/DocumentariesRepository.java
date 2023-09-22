package com.novare.natflixbackend.repositories.contents;

import com.novare.natflixbackend.models.contents.Documentaries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentariesRepository extends JpaRepository<Documentaries, Integer> {
}
