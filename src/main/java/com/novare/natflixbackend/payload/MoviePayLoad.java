package com.novare.natflixbackend.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflixbackend.models.contents.AdditionalDetails;
import com.novare.natflixbackend.models.contents.Movies;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoviePayLoad extends ContentPayLoad{
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("content_id")
    private Integer contId;

    @JsonProperty("video_code")
    private String videoCode;


    public static List<MoviePayLoad> createMoviePayLoad(List<Movies> moviesList) {
        List<MoviePayLoad> movieResponses = new ArrayList<>();
        for (Movies movies : moviesList) {
            MoviePayLoad response = new MoviePayLoad();
            AdditionalDetails details = movies.getAdditionalDetails();
            response.setContId(movies.getContent().getId());
            response.setId(movies.getId());
            response.setVideoCode(details.getVideoCode());
            movieResponses.add(response);
        }

        return movieResponses;
    }
}
