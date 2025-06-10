package com.cinemaproject.appcore.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cinemaproject.appcore.Model.Movie;

import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveCrudRepository<Movie, String> {

}
