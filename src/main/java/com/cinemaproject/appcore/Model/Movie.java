package com.cinemaproject.appcore.Model;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import io.swagger.v3.oas.annotations.Hidden;


@Table(name = "movies")
@JsonDeserialize(builder = Movie.Builder.class)
public class Movie {

    @Hidden
    private Integer id;

    private String Name;


    private String Description;
    private String Director;

    public Movie() {}

    @Column("release_date")
    private LocalDate ReleaseDate;


    @Column("genre")
    private List<Genre> Genre;
    private Integer Duration;


    private String Observation;

    @Column("origin_country")
    private String OriginCountry;
    private String Actors;
    private String Language;


    private Movie(Builder builder) {
        this.id = builder.id;
        this.Name = builder.Name;
        this.Description = builder.Description;
        this.Director = builder.Director;
        this.ReleaseDate = builder.ReleaseDate;
        this.Genre = builder.Genre;
        this.Duration = builder.Duration;
        this.Observation = builder.Observation;
        this.OriginCountry = builder.OriginCountry;
        this.Actors = builder.Actors;
        this.Language = builder.Language;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private Integer id;
        private String Name;
        private String Description;
        private String Director;
        private LocalDate ReleaseDate;
        private List<Genre> Genre;
        private Integer Duration;
        private String Observation;
        private String OriginCountry;
        private String Actors;
        private String Language;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder Name(String name) {
            this.Name = name;
            return this;
        }

        public Builder Description(String description) {
            this.Description = description;
            return this;
        }

        public Builder Director(String director) {
            this.Director = director;
            return this;
        }

        public Builder ReleaseDate(LocalDate releaseDate) {
            this.ReleaseDate = releaseDate;
            return this;
        }

        public Builder Genre(List<com.cinemaproject.appcore.Model.Genre> genre) {
            this.Genre = genre;
            return this;
        }

        public Builder Duration(Integer duration) {
            this.Duration = duration;
            return this;
        }

        public Builder Observation(String observation) {
            this.Observation = observation;
            return this;
        }

        public Builder OriginCountry(String originCountry) {
            this.OriginCountry = originCountry;
            return this;
        }

        public Builder Actors(String actors) {
            this.Actors = actors;
            return this;
        }

        public Builder Language(String language) {
            this.Language = language;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public LocalDate getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        ReleaseDate = releaseDate;
    }

    public List<Genre> getGenre() {
        return Genre;
    }

    public void setGenre(List<Genre> genre) {
        Genre = genre;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }

    public String getOriginCountry() {
        return OriginCountry;
    }

    public void setOriginCountry(String originCountry) {
        OriginCountry = originCountry;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

}
