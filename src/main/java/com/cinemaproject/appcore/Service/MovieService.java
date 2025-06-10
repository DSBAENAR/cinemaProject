package com.cinemaproject.appcore.Service;

import org.springframework.stereotype.Service;

import com.cinemaproject.appcore.Model.Movie;
import com.cinemaproject.appcore.Repository.MovieRepository;

import reactor.core.publisher.Flux;

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
}
