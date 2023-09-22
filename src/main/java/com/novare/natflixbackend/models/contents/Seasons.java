package com.novare.natflixbackend.models.contents;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "seasons")
public class Seasons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer seasonNumber;
    
    @OneToMany(mappedBy = "season", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Episodes> episodes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "SEASON_SERIES_ID"), referencedColumnName = "ID")
    private Series series;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Set<Episodes> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episodes> episodes) {
        this.episodes = episodes;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }


}
