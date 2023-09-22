package com.novare.natflixbackend.payload;

import java.util.*;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflixbackend.exceptions.BackEndException;
import com.novare.natflixbackend.models.contents.*;
import com.novare.natflixbackend.utills.PhotoConverter;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ContentPayLoad implements Comparable<ContentPayLoad> {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("title")
	@NotEmpty
	private String title;

	@JsonProperty("type_id")
	@NotEmpty
	private Integer typeId;

	@JsonProperty("category_id")
	@NotEmpty
	private Integer catId;

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("logo_url")
	private String logUrl;

	@JsonProperty("poster_url")
	private String posterUrl;

	@JsonProperty("banner_url")
	private String bannerUrl;

	@JsonProperty("thumbnail_url")
	private String thumbnailUrl;

	@JsonProperty("season_number")
	private Integer seasonNumber;

	@JsonProperty("episode_number")
	private Integer episodeNumber;

	@JsonProperty("episode_url")
	private String episodeUrl;

	@JsonProperty("video_code")
	private String videoCode;


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		ContentPayLoad contentPayLoad = (ContentPayLoad) obj;
		return this.getId() == contentPayLoad.getId();
	}

	@Override
	public int compareTo(ContentPayLoad o) {
		return getId().compareTo(o.getId());
	}

	public static List<ContentPayLoad> getContentSubSet(List<Content> contents, EType eType) throws BackEndException {
		List<ContentPayLoad> contentResponses = new ArrayList<>();

		for (Content content : contents) {
			Integer typeId = content.getContentType().getId();

			if (eType == EType.fromTypeId(typeId)|| eType == EType.CONTENT) {
				List<ContentPayLoad> typeContent = buildContentSubSet(content, typeId);
				contentResponses.addAll(typeContent);
			}
		}

		return contentResponses;
	}

	public static List<ContentPayLoad> buildContentSubSet(Content content, Integer typeId) {
		List<ContentPayLoad> contentResponse = new ArrayList<>();

		if (typeId == 1) {
			contentResponse.addAll(buildSeries(content.getSeries(), typeId));
		} else if (typeId == 2) {
			contentResponse.addAll(buildMovies(content.getMovies(), typeId));
		} else if (typeId == 3) {
			contentResponse.addAll(buildDocumentaries(content.getDocumentaries(), typeId));
		} else {
			throw new IllegalArgumentException("Unexpected value: " + typeId);
		}

		Collections.sort(contentResponse);
		return contentResponse;
	}

	public static List<ContentPayLoad> buildSeries(Set<Series> seriesSet, Integer typeId) {
		List<ContentPayLoad> seriesResponse = new ArrayList<>();
		for (Series series : seriesSet) {
			AdditionalDetails additional = series.getAdditionalDetails();
			ContentPayLoad response = createResponse(additional, series.getId(), series.getCategory().getId(), typeId);
			seriesResponse.add(response);
		}
		Collections.sort(seriesResponse);
		return seriesResponse;
	}

	public static List<ContentPayLoad> buildMovies(Set<Movies> moviesSet, Integer typeId) {
		List<ContentPayLoad> movieResponse = new ArrayList<>();
		for (Movies movie : moviesSet) {
			AdditionalDetails additional = movie.getAdditionalDetails();
			ContentPayLoad response = createResponse(additional, movie.getId(), movie.getCategory().getId(), typeId);
			movieResponse.add(response);
		}
		Collections.sort(movieResponse);
		return movieResponse;
	}

	public static List<ContentPayLoad> buildDocumentaries(Set<Documentaries> documentaries, Integer typeId) {
		List<ContentPayLoad> documentResponse = new ArrayList<>();
		for (Documentaries document : documentaries) {
			AdditionalDetails additional = document.getAdditionalDetails();
			ContentPayLoad response = createResponse(additional, document.getId(), document.getCategory().getId(), typeId);
			documentResponse.add(response);
		}
		Collections.sort(documentResponse);
		return documentResponse;
	}

	public static ContentPayLoad createResponse(AdditionalDetails additional, int id, int catId, int typeId) {
		ContentPayLoad response = new ContentPayLoad();
		response.setCatId(catId);
		response.setId(id);
		response.setTypeId(typeId);
		response.setBannerUrl(PhotoConverter.toBase64(additional.getBannerUrl()));
		response.setLogUrl(PhotoConverter.toBase64(additional.getLogoUrl()));
		response.setThumbnailUrl(PhotoConverter.toBase64(additional.getThumbnailUrl()));
		response.setEpisodeUrl(PhotoConverter.toBase64(additional.getEpisodeUrl()));
		response.setSummary(additional.getSummary());
		response.setTitle(additional.getTitle());
		response.setVideoCode(additional.getVideoCode());
		return response;
	}

	public static Series getSeriesSubSet(ContentPayLoad builder) {
		AdditionalDetails additionalModel = createAdditionalData(builder);
		Series series = new Series();
		series.setId(builder.getId());
		series.setAdditionalDetails(additionalModel);
		return series;
	}
	public static Movies getMoviesSubSet(ContentPayLoad request) {
		AdditionalDetails additionalModel = createAdditionalData(request);
		Movies movies = new Movies();
		movies.setId(request.getId());
		movies.setAdditionalDetails(additionalModel);
		return movies;
	}

	public static Documentaries getDocumentSubSet(ContentPayLoad request) {
		AdditionalDetails additionalModel = createAdditionalData(request);
		Documentaries documentaries = new Documentaries();
		documentaries.setId(request.getId());
		documentaries.setAdditionalDetails(additionalModel);
		return documentaries;
	}
	private static AdditionalDetails createAdditionalData(ContentPayLoad builder) {
		AdditionalDetails details = new AdditionalDetails();
		details.setSummary(builder.getSummary());
		details.setBannerUrl(PhotoConverter.toImageFile(builder.getBannerUrl(), "banners/"));
		details.setLogoUrl(PhotoConverter.toImageFile(builder.getLogUrl(), "logos/"));
		details.setThumbnailUrl(PhotoConverter.toImageFile(builder.getThumbnailUrl(), "thumbnails/"));
		details.setEpisodeUrl(PhotoConverter.toImageFile(builder.getEpisodeUrl(), "episodes/"));
		details.setTitle(builder.getTitle());
		details.setVideoCode(builder.getVideoCode());
		return details;
	}
}
