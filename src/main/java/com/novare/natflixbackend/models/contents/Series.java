package com.novare.natflixbackend.models.contents;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(foreignKey = @ForeignKey(name = "SERIES_CAT_ID"), name = "CATEGORY_ID", referencedColumnName = "ID")
    private ContentCategory category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "SERIES_ADD_ID"), name = "ADDITIONAL_ID", referencedColumnName = "ID")
    private AdditionalDetails additionalDetails;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(foreignKey = @ForeignKey(name = "SER_CONTENT_ID"), name = "CONTENT_ID", referencedColumnName = "ID")
    private Content content;

    @OneToMany(mappedBy = "series", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Seasons> seasons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdditionalDetails getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(AdditionalDetails additional) {
        this.additionalDetails = additional;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Set<Seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Seasons> seasons) {
        this.seasons = seasons;
    }

    public ContentCategory getCategory() {
        return category;
    }

    public void setCategory(ContentCategory category) {
        this.category = category;
    }
}
