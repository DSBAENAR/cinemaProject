package com.cinemaproject.appcore.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cinemaproject.appcore.Model.Movie;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface MovieRepository extends ReactiveCrudRepository<Movie, String> {

    Mono<Movie> findTopByOrderByIdDesc();

    Mono<Boolean> existsByName(String name);

    Mono<Movie> findByName(String name);

    Flux<Movie> findByGenre(String genre);
    Flux<Movie> findByOriginCountry(String originCountry);
    Flux<Movie> findByLanguage(String language);
    Flux<Movie> findByReleaseDate(String releaseDate);
    Flux<Movie> findByActorsContaining(String actorName);
    Flux<Movie> findByDirector(String director);
    Flux<Movie> findByDuration(Integer duration);
    Flux<Movie> findByNameContaining(String keyword);
    Flux<Movie> findByActors(String actors);

}
