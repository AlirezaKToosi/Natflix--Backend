package com.novare.natflixbackend.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflixbackend.models.contents.AdditionalDetails;
import com.novare.natflixbackend.models.contents.Documentaries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentPayLoad extends ContentPayLoad {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("content_id")
    private Integer contId;


    public static List<DocumentPayLoad> createDocumentPayLoad(List<Documentaries> documentariesList) {
        List<DocumentPayLoad> documentResponses = new ArrayList<>();
        for (Documentaries documentaries : documentariesList) {
            DocumentPayLoad response = new DocumentPayLoad();
            AdditionalDetails details = documentaries.getAdditionalDetails();
            response.setContId(documentaries.getContent().getId());
            response.setId(documentaries.getId());
            response.setVideoCode(details.getVideoCode());
            documentResponses.add(response);
        }

        return documentResponses;
    }
}
