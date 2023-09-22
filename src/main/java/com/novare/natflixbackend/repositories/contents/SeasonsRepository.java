package com.novare.natflixbackend.repositories.contents;

import com.novare.natflixbackend.models.contents.Seasons;
import com.novare.natflixbackend.models.contents.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonsRepository extends JpaRepository<Seasons, Integer> {
    Seasons findBySeriesAndSeasonNumber(Series series, int seasonId);
}
