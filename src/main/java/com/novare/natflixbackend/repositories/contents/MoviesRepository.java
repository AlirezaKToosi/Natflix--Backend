package com.novare.natflixbackend.repositories.contents;

import com.novare.natflixbackend.models.contents.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository  extends JpaRepository<Movies, Integer> {
}
