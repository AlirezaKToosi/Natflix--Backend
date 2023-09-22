package com.novare.natflixbackend.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflixbackend.models.contents.AdditionalDetails;
import com.novare.natflixbackend.models.contents.Episodes;
import com.novare.natflixbackend.utills.PhotoConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeasonsPayLoad extends ContentPayLoad {

    @JsonProperty("season_number")
    private Integer season;

    @JsonProperty("episode_number")
    private Integer episode;


    public static Episodes getEpisodsSubSets(SeasonsPayLoad builder) {
        AdditionalDetails additionalDetail = createAdditionalModel(builder);
        Episodes episodes = new Episodes();
        episodes.setAdditionalDetails(additionalDetail);
        return episodes;
    }
    private static AdditionalDetails createAdditionalModel(SeasonsPayLoad builder) {
        AdditionalDetails details = new AdditionalDetails();
        details.setSummary(builder.getSummary());
        details.setThumbnailUrl(PhotoConverter.toImageFile(builder.getThumbnailUrl(), "thumbnails/"));
        details.setTitle(builder.getTitle());
        details.setVideoCode(builder.getVideoCode());
        return details;
    }
}
