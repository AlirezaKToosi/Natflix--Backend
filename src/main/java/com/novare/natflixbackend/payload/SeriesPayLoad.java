package com.novare.natflixbackend.payload;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflixbackend.models.contents.AdditionalDetails;
import com.novare.natflixbackend.models.contents.Episodes;
import com.novare.natflixbackend.models.contents.Seasons;
import com.novare.natflixbackend.models.contents.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "type_id", "category_id", "logo_url", "poster_url", "banner_url", "number_of_oscars",
        "seasons" })
public class SeriesPayLoad extends ContentPayLoad {

    @JsonProperty("content_id")
    private Integer contId;

    @JsonProperty("season_number")
    private Integer seasonNumber;

    @JsonProperty("episode_number")
    private Integer episodeNumber;

    @JsonProperty("video_code")
    private String videoCode;

    @JsonProperty("seasons")
    private Set<SeasonsPayLoad> seasons;

    public static List<ContentPayLoad> createSeriesPayLoad(Series series) {
        List<ContentPayLoad> seriesResponse = new ArrayList<>();
        for (Seasons seasons : series.getSeasons()) {
            for (Episodes episodes : seasons.getEpisodes()) {
                AdditionalDetails details = episodes.getAdditionalDetails();
                ContentPayLoad dto = createResponse(details, episodes.getId(), series.getCategory().getId(), 1);
                dto.setEpisodeNumber(episodes.getEpisodeNumber());
                dto.setSeasonNumber(seasons.getSeasonNumber());
                seriesResponse.add(dto);
            }
        }
        Collections.sort(seriesResponse);
        return seriesResponse;
    }
}
