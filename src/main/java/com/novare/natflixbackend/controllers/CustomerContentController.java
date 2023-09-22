package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.exceptions.BackEndException;
import com.novare.natflixbackend.models.contents.*;
import com.novare.natflixbackend.payload.ContentPayLoad;
import com.novare.natflixbackend.payload.DocumentPayLoad;
import com.novare.natflixbackend.payload.MoviePayLoad;
import com.novare.natflixbackend.payload.SeriesPayLoad;
import com.novare.natflixbackend.services.contents.ContentService;
import com.novare.natflixbackend.services.contents.DocumentariesService;
import com.novare.natflixbackend.services.contents.MoviesService;
import com.novare.natflixbackend.services.contents.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Validated
public class CustomerContentController {
    @Autowired
    private ContentService contentService;
    @Autowired
    private DocumentariesService documentariesService;
    @Autowired
    private SeriesService seriesService;
    @Autowired
    private MoviesService moviesService;

    @GetMapping("/content/")
    public ResponseEntity<List<ContentPayLoad>> findAll() throws BackEndException {
        List<Content> contents = contentService.getAllContent();
        List<ContentPayLoad> responses = ContentPayLoad.getContentSubSet(contents, EType.CONTENT);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/content/movies/")
    public ResponseEntity<List<ContentPayLoad>> findMovies() throws BackEndException {
        List<Content> contents = contentService.getAllContent();
        List<ContentPayLoad> responses = ContentPayLoad.getContentSubSet(contents, EType.MOVIES);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/content/series/")
    public ResponseEntity<List<ContentPayLoad>> findSeries() throws BackEndException {
        List<Content> contents = contentService.getAllContent();
        List<ContentPayLoad> responses = ContentPayLoad.getContentSubSet(contents, EType.SERIES);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/content/documentaries/")
    public ResponseEntity<List<ContentPayLoad>> findDocumentries() throws BackEndException {
        List<Content> contents = contentService.getAllContent();
        List<ContentPayLoad> responses = ContentPayLoad.getContentSubSet(contents, EType.DOCUMENTARIES);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping({"/content/details-series/{id}/", "/details-series/{id}/"})
    public ResponseEntity<List<ContentPayLoad>> getBySeriesId(@PathVariable(value = "id") Integer seriesId)
            throws BackEndException {
        Series series = seriesService.findSeriesById(seriesId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Series not found on :: " + seriesId));
        List<ContentPayLoad> response = SeriesPayLoad.createSeriesPayLoad(series);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping({"/content/details-movies/{id}/", "/details-movies/{id}/"})
    public ResponseEntity<ContentPayLoad> getByMoviesId(@PathVariable(value = "id") Integer movieId)
            throws BackEndException {
        Movies movies = moviesService.findMovieById(movieId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Movie not found on :: " + movieId));
        ContentPayLoad response = MoviePayLoad.createResponse(movies.getAdditionalDetails(), movies.getId(),
                movies.getCategory().getId(), 2);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping({"/content/details-documentaries/{id}/","/details-documentaries/{id}/"})
    public ResponseEntity<ContentPayLoad> getByDocumentariesId(@PathVariable(value = "id") Integer documentId)
            throws BackEndException {
        Documentaries documentaries = documentariesService.findDocumentaryById(documentId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Documentaries not found on :: " + documentId));
        ContentPayLoad response = DocumentPayLoad.createResponse(documentaries.getAdditionalDetails(), documentaries.getId(),
                documentaries.getCategory().getId(), 3);
        return ResponseEntity.ok().body(response);
    }

}
