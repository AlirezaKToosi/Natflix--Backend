package com.novare.natflixbackend.repositories.contents;

import com.novare.natflixbackend.models.contents.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
}
