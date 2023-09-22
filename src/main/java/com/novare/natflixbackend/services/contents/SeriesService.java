package com.novare.natflixbackend.services.contents;

import com.novare.natflixbackend.models.contents.Series;
import com.novare.natflixbackend.repositories.contents.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;

    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    public Optional<Series> findSeriesById(Integer seriesId) {
        return seriesRepository.findById(seriesId);
    }

    public void deleteSeries(Series series) {
        seriesRepository.delete(series);
    }

    public void saveSeries(Series series) {
        seriesRepository.save(series);
    }
}
