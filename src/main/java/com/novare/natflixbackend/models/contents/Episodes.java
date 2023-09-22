package com.novare.natflixbackend.models.contents;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "episodes")
@Data
public class Episodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer episodeNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "EPISODE_ADD_ID"), name = "ADDITIONAL_ID", referencedColumnName = "ID")
    private AdditionalDetails additionalDetails;

    @ManyToOne(fetch = FetchType.LAZY, optional = false , cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(foreignKey = @ForeignKey(name = "EPI_SEASON_ID"), name = "SEASON_ID", referencedColumnName = "ID")
    private Seasons season;

}
