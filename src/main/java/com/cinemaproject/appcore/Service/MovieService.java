package com.cinemaproject.appcore.Service;


import org.springframework.stereotype.Service;

import com.cinemaproject.appcore.Model.Movie;
import com.cinemaproject.appcore.Repository.MovieRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Retrieves all movies from the repository.
     *
     * @return a Flux containing all movies.
     */
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll()
                .switchIfEmpty(Flux.error(new RuntimeException("No movies found")));
    }

    public Mono<Movie> addMovie(Movie movie) {
        Movie movieBuild = new Movie.Builder()
                .Name(movie.getName())
                .Description(movie.getDescription())
                .Director(movie.getDirector())
                .ReleaseDate(movie.getReleaseDate())
                .Genre(movie.getGenre())
                .Duration(movie.getDuration())
                .Observation(movie.getObservation())
                .OriginCountry(movie.getOriginCountry())
                .Actors(movie.getActors())
                .Language(movie.getLanguage())
                .build();
        
       
       return validateMovie(movieBuild)
        .then(
            movieRepository.findTopByOrderByIdDesc()
                .map(lastMovie -> lastMovie.getId() + 1)
                .defaultIfEmpty(1)
                .flatMap(newId -> {
                    movieBuild.setId(newId);
                    return movieRepository.save(movieBuild);
                })
        );

    } 

    public Mono<Void> validateMovie(Movie movie) {
        return movieRepository.existsByName(movie.getName())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new RuntimeException("Movie already exists"));
                    }
                    if (movie.getName() == null || movie.getName().isEmpty()) {
                        return Mono.error(new RuntimeException("Movie name cannot be empty"));
                    }
                    if (movie.getDescription() == null || movie.getDescription().isEmpty()) {
                        return Mono.error(new RuntimeException("Movie description cannot be empty"));
                    }
                    if (movie.getReleaseDate() == null) {
                        return Mono.error(new RuntimeException("Movie release date cannot be empty"));
                    }
                    if (movie.getGenre() == null) {
                        return Mono.error(new RuntimeException("Movie genre cannot be empty"));
                    }
                    if (movie.getDirector() == null || movie.getDirector().isEmpty()) {
                        return Mono.error(new RuntimeException("Movie director cannot be empty"));
                    }
                    if (movie.getLanguage() == null || movie.getLanguage().isEmpty()) {
                        return Mono.error(new RuntimeException("Movie language cannot be empty"));
                    }
                    if (movie.getDuration() == null) {
                        return Mono.error(new RuntimeException("Movie duration cannot be empty"));
                    }
                    if (movie.getOriginCountry() == null || movie.getOriginCountry().isEmpty()) {
                        return Mono.error(new RuntimeException("Movie origin country cannot be empty"));
                    }
                    return Mono.empty();
                });
    }


}
