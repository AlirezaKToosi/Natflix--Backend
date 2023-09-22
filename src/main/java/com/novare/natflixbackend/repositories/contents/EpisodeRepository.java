package com.novare.natflixbackend.repositories.contents;

import com.novare.natflixbackend.models.contents.Episodes;
import com.novare.natflixbackend.models.contents.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episodes, Integer> {
    Episodes findBySeasonAndEpisodeNumber(Seasons seasons,int episodesId);
}
