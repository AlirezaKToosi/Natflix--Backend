package com.novare.natflixbackend.services.contents;

import com.novare.natflixbackend.models.contents.Episodes;
import com.novare.natflixbackend.models.contents.Seasons;
import com.novare.natflixbackend.repositories.contents.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    public Episodes findEpisodeBySeasonAndEpisodeNumber(Seasons season, int episodeNumber) {
        return episodeRepository.findBySeasonAndEpisodeNumber(season, episodeNumber);
    }

    public List<Episodes> getAllEpisodes() {
        return episodeRepository.findAll();
    }

    public Optional<Episodes> findEpisodeById(Integer episodeId) {
        return episodeRepository.findById(episodeId);
    }

    public void deleteEpisode(Episodes episode) {
        episodeRepository.delete(episode);
    }

    public void saveEpisode(Episodes episode) {
        episodeRepository.save(episode);
    }

}
