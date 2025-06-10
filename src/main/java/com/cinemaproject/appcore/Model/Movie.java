package com.cinemaproject.appcore.Model;

import java.time.LocalTime;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "movies")
public class Movie {
    
  
    private String id;

   
    private String Name;


    private String Description;
    private String Director;

    public Movie() {}

    @Column("releaseDate")
    private LocalTime ReleaseDate;
    private String Genre;
    private LocalTime Duration;


    private String Observation;

    @Column("originCountry")
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

    public static class Builder {
        private String id;
        private String Name;
        private String Description;
        private String Director;
        private LocalTime ReleaseDate;
        private String Genre;
        private LocalTime Duration;
        private String Observation;
        private String OriginCountry;
        private String Actors;
        private String Language;

        public Builder id(String id) {
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

        public Builder ReleaseDate(LocalTime releaseDate) {
            this.ReleaseDate = releaseDate;
            return this;
        }

        public Builder Genre(String genre) {
            this.Genre = genre;
            return this;
        }

        public Builder Duration(LocalTime duration) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public LocalTime getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(LocalTime releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public LocalTime getDuration() {
        return Duration;
    }

    public void setDuration(LocalTime duration) {
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
