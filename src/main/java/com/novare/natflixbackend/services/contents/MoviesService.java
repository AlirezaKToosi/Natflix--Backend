package com.novare.natflixbackend.services.contents;

import com.novare.natflixbackend.models.contents.Movies;
import com.novare.natflixbackend.repositories.contents.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Optional<Movies> findMovieById(Integer movieId) {
        return moviesRepository.findById(movieId);
    }

    public void deleteMovie(Movies movie) {
        moviesRepository.delete(movie);
    }

    public void saveMovie(Movies movie) {
        moviesRepository.save(movie);
    }
}
