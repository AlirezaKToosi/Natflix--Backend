package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.exceptions.BackEndException;
import com.novare.natflixbackend.models.contents.*;
import com.novare.natflixbackend.payload.*;
import com.novare.natflixbackend.payload.response.InfoResponse;
import com.novare.natflixbackend.services.contents.*;
import com.novare.natflixbackend.utills.PhotoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Validated
public class AdminContentController {


    private final ContentService contentService;
    private final MoviesService moviesService;
    private final SeriesService seriesService;
    private final DocumentariesService documentariesService;
    private final EpisodeService episodeService;
    private final SeasonsService seasonsService;
    private final ContentCategoryService contentCategoryService;
    private final ContentTypeService contentTypeService;


    @Autowired
    public AdminContentController(
            ContentService contentService,
            MoviesService moviesService,
            SeriesService seriesService,
            DocumentariesService documentariesService,
            EpisodeService episodeService,
            SeasonsService seasonsService,
            ContentCategoryService contentCategoryService,
            ContentTypeService contentTypeService
    ) {
        this.contentService = contentService;
        this.moviesService = moviesService;
        this.seriesService = seriesService;
        this.documentariesService = documentariesService;
        this.episodeService = episodeService;
        this.seasonsService = seasonsService;
        this.contentCategoryService = contentCategoryService;
        this.contentTypeService = contentTypeService;
    }

    @GetMapping("/admin-content/")
    public ResponseEntity<List<ContentPayLoad>> findAll() throws BackEndException {
        List<Content> contents = contentService.getAllContent();
        List<ContentPayLoad> responses = ContentPayLoad.getContentSubSet(contents, EType.CONTENT);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/admin-content/movies/")
    public ResponseEntity<List<ContentPayLoad>> findMovies() throws BackEndException {
        List<Content> contents = contentService.getAllContent();
        List<ContentPayLoad> responses = ContentPayLoad.getContentSubSet(contents, EType.MOVIES);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/admin-content/series/")
    public ResponseEntity<List<ContentPayLoad>> findSeries() throws BackEndException {
        List<Content> contents = contentService.getAllContent();
        List<ContentPayLoad> responses = ContentPayLoad.getContentSubSet(contents, EType.SERIES);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/admin-content/documentaries/")
    public ResponseEntity<List<ContentPayLoad>> findDocumentries() throws BackEndException {
        List<Content> contents = contentService.getAllContent();
        List<ContentPayLoad> responses = ContentPayLoad.getContentSubSet(contents, EType.DOCUMENTARIES);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/admin-details-series/{id}/")
    public ResponseEntity<List<ContentPayLoad>> getBySeriesId(@PathVariable(value = "id") Integer seriesId)
            throws BackEndException {
        Series series = seriesService.findSeriesById(seriesId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Series not found on :: " + seriesId));
        List<ContentPayLoad> response = SeriesPayLoad.createSeriesPayLoad(series);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/admin-details-movies/{id}/")
    public ResponseEntity<ContentPayLoad> getByMoviesId(@PathVariable(value = "id") Integer movieId)
            throws BackEndException {
        Movies movies = moviesService.findMovieById(movieId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Movie not found on :: " + movieId));
        ContentPayLoad response = MoviePayLoad.createResponse(movies.getAdditionalDetails(), movies.getId(),
                movies.getCategory().getId(), 2);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/admin-details-documentaries/{id}/")
    public ResponseEntity<ContentPayLoad> getByDocId(@PathVariable(value = "id") Integer documentId)
            throws BackEndException {
        Documentaries documentaries = documentariesService.findDocumentaryById(documentId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "documentaries not found on :: " + documentId));
        ContentPayLoad response = DocumentPayLoad.createResponse(documentaries.getAdditionalDetails(), documentaries.getId(),
                documentaries.getCategory().getId(), 3);
        return ResponseEntity.ok().body(response);
    }


    @PutMapping("/admin-details-movies/update/{id}/")
    public ResponseEntity<?> updateMovieDetails(@PathVariable(value = "id") Integer movieId, @RequestBody SeasonsPayLoad contentRequest)
            throws BackEndException {
        try {
            Movies movies = moviesService.findMovieById(movieId)
                    .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Movie not found on :: " + movieId));

            movies.getAdditionalDetails().setVideoCode(contentRequest.getVideoCode());
            moviesService.saveMovie(movies);
            ContentPayLoad response = MoviePayLoad.createResponse(movies.getAdditionalDetails(), movies.getId(),
                    movies.getCategory().getId(), 2);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new BackEndException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @PutMapping("/admin-details-documentaries/update/{id}/")
    public ResponseEntity<?> updateDocumentariesDetails(@PathVariable(value = "id") Integer documentId, @RequestBody DocumentPayLoad contentRequest)
            throws BackEndException {
        try {
            Documentaries documentaries = documentariesService.findDocumentaryById(documentId)
                    .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Documentaries not found on :: " + documentId));

            documentaries.getAdditionalDetails().setVideoCode(contentRequest.getVideoCode());
            documentariesService.saveDocumentary(documentaries);
            ContentPayLoad response = DocumentPayLoad.createResponse(documentaries.getAdditionalDetails(), documentaries.getId(),
                    documentaries.getCategory().getId(), 3);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new BackEndException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }


    @PostMapping("/admin-content/create/")
    public ResponseEntity<ContentPayLoad> create(@RequestBody ContentPayLoad contentRequest) throws BackEndException {
        requestHandler(contentRequest);
        return ResponseEntity.ok(contentRequest);
    }

    @RequestMapping(value = {"/admin-details-series/create/{id}/", "/admin-details-series/update/{id}/"}, method = {RequestMethod.POST, RequestMethod.PUT})

    public ResponseEntity<?> addSeasonToSeries(@PathVariable(value = "id") Integer seriesId, @RequestBody SeasonsPayLoad seasonDTO) {
        try {
            // Fetch the series by ID
            Series series = seriesService.findSeriesById(seriesId)
                    .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Series not found on :: " + seriesId));

            // Check if a season with the given season number already exists for the series
            Seasons existingSeason = seasonsService.findSeasonBySeriesAndSeasonNumber(series, seasonDTO.getSeason());
            if (existingSeason == null) {
                Seasons season = new Seasons();
                season.setSeasonNumber(seasonDTO.getSeason());
                season.setSeries(series);
                existingSeason = season;
                Episodes episode = SeasonsPayLoad.getEpisodsSubSets(seasonDTO);
                episode.setEpisodeNumber(seasonDTO.getEpisode());
                episode.setSeason(existingSeason);
                episodeService.saveEpisode(episode);
                return ResponseEntity.ok().body("Season added to series successfully");
            }

            Episodes existingEpisode = episodeService.findEpisodeBySeasonAndEpisodeNumber(existingSeason, seasonDTO.getEpisode());
            if (existingEpisode == null) {
                Episodes episode = SeasonsPayLoad.getEpisodsSubSets(seasonDTO);
                episode.setEpisodeNumber(seasonDTO.getEpisode());
                episode.setSeason(existingSeason);
                episodeService.saveEpisode(episode);
                return ResponseEntity.ok().body("Season added to series successfully");
            }

            // Update the AdditionalDetails for the episode
            AdditionalDetails additionalDetails = existingEpisode.getAdditionalDetails();
            if (additionalDetails == null) {
                additionalDetails = new AdditionalDetails();
            }
            additionalDetails.setTitle(seasonDTO.getTitle());
            additionalDetails.setThumbnailUrl(PhotoConverter.toImageFile(seasonDTO.getThumbnailUrl(), "thumbnails/"));
            additionalDetails.setVideoCode(seasonDTO.getVideoCode());
            additionalDetails.setSummary(seasonDTO.getSummary());

            existingEpisode.setAdditionalDetails(additionalDetails);
            episodeService.saveEpisode(existingEpisode);

            return ResponseEntity.ok().body("Season added to series successfully");
        } catch (Exception e) {
            throw new BackEndException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @PutMapping("/admin-content/update-movies/")
    public ResponseEntity<?> updateMovies(@RequestBody ContentPayLoad contentRequest) throws BackEndException {
        Movies movies = moviesService.findMovieById(contentRequest.getId())
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Movie not found on :: " + contentRequest.getId()));
        ContentType contentType = contentTypeService.findContentTypeById(contentRequest.getTypeId())
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "contentType not found on :: " + contentRequest.getTypeId()));
        if (!contentType.getType().equalsIgnoreCase(EType.MOVIES.toString())) {
            contentRequest.setId(null);
            moviesService.deleteMovie(movies);
        }
        requestHandler(contentRequest);
        return ResponseEntity.ok(new InfoResponse("Movie updated successfully"));
    }

    @PutMapping("/admin-content/update-documentaries/")
    public ResponseEntity<?> updateDocumentaries(@RequestBody ContentPayLoad contentRequest) throws BackEndException {
        Documentaries documentaries = documentariesService.findDocumentaryById(contentRequest.getId()).orElseThrow(
                () -> new BackEndException(HttpStatus.NOT_FOUND, "Documentaries not found on :: " + contentRequest.getId()));
        ContentType contentType = contentTypeService.findContentTypeById(contentRequest.getTypeId())
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "contentType not found on :: " + contentRequest.getTypeId()));
        if (!contentType.getType().equalsIgnoreCase(EType.DOCUMENTARIES.toString())) {
            contentRequest.setId(null);
            documentariesService.deleteDocumentary(documentaries);
        }
        requestHandler(contentRequest);
        return ResponseEntity.ok(new InfoResponse("Documentary updated successfully"));
    }

    @PutMapping("/admin-content/update-series/")
    public ResponseEntity<?> updateSeries(@RequestBody ContentPayLoad contentRequest) throws BackEndException {
        Series series = seriesService.findSeriesById(contentRequest.getId())
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Series not found on :: " + contentRequest.getId()));
        ContentType contentType = contentTypeService.findContentTypeById(contentRequest.getTypeId())
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "contentType not found on :: " + contentRequest.getTypeId()));
        if (!contentType.getType().equalsIgnoreCase(EType.SERIES.toString())) {
            contentRequest.setId(null);
            seriesService.deleteSeries(series);
        }
        requestHandler(contentRequest);
        return ResponseEntity.ok(new InfoResponse("Series updated successfully"));
    }

    @DeleteMapping("/admin-content/delete-series/{id}")
    public Map<String, Boolean> deleteSeries(@PathVariable(value = "id") Integer seriesId) throws BackEndException {

        Series series = seriesService.findSeriesById(seriesId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Series not found on :: " + seriesId));
        seriesService.deleteSeries(series);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/admin-content/delete-episode/{id}")
    public Map<String, Boolean> deleteEpisode(@PathVariable(value = "id") Integer episodeId) throws BackEndException {

        Episodes episode = episodeService.findEpisodeById(episodeId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Episode not found on :: " + episodeId));
        episodeService.deleteEpisode(episode);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/admin-content/delete-movies/{id}")
    public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") Integer movieId) throws BackEndException {

        Movies movies = moviesService.findMovieById(movieId)
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND, "Movie not found on :: " + movieId));
        moviesService.deleteMovie(movies);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/admin-content/delete-documentaries/{id}")
    public Map<String, Boolean> deleteDocumentaries(@PathVariable(value = "id") Integer documentId)
            throws BackEndException {

        Documentaries documentaries =  documentariesService.findDocumentaryById(documentId).orElseThrow(
                () -> new BackEndException(HttpStatus.NOT_FOUND, "Documentaries not found on :: " + documentId));
        documentariesService.deleteDocumentary(documentaries);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private void requestHandler(ContentPayLoad contentRequest) {
        ContentCategory category = contentCategoryService.findContentCategoryById(contentRequest.getCatId())
                .orElseThrow(() -> new BackEndException(HttpStatus.NOT_FOUND,
                        "Category not found on :: " + contentRequest.getCatId()));
        switch (contentRequest.getTypeId()) {
            case 1 -> {
                Series series = ContentPayLoad.getSeriesSubSet(contentRequest);
                series.setCategory(category);
                Content findByContentType = contentService.findByContentType(EType.SERIES.name());
                series.setContent(findByContentType);
                seriesService.saveSeries(series);
            }
            case 2 -> {
                Movies movies = ContentPayLoad.getMoviesSubSet(contentRequest);
                movies.setCategory(category);
                Content findByContentType = contentService.findByContentType(EType.MOVIES.name());
                movies.setContent(findByContentType);
                moviesService.saveMovie(movies);
            }
            case 3 -> {
                Documentaries documentaries = ContentPayLoad.getDocumentSubSet(contentRequest);
                documentaries.setCategory(category);
                Content findByContentType = contentService.findByContentType(EType.DOCUMENTARIES.name());
                documentaries.setContent(findByContentType);
                documentariesService.saveDocumentary(documentaries);
            }

            default -> throw new IllegalArgumentException("Unexpected value: " + contentRequest.getTypeId());
        }
    }
}
