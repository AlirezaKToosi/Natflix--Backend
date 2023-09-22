package com.novare.natflixbackend.services.contents;

import com.novare.natflixbackend.models.contents.Seasons;
import com.novare.natflixbackend.models.contents.Series;
import com.novare.natflixbackend.repositories.contents.SeasonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonsService {

    @Autowired
    private SeasonsRepository seasonsRepository;

    public Seasons findSeasonBySeriesAndSeasonNumber(Series series, int seasonNumber) {
        return seasonsRepository.findBySeriesAndSeasonNumber(series, seasonNumber);
    }

    public List<Seasons> getAllSeasons() {
        return seasonsRepository.findAll();
    }

    public Optional<Seasons> findSeasonById(Integer seasonId) {
        return seasonsRepository.findById(seasonId);
    }

    public void deleteSeason(Seasons season) {
        seasonsRepository.delete(season);
    }

    public void saveSeason(Seasons season) {
        seasonsRepository.save(season);
    }
}
