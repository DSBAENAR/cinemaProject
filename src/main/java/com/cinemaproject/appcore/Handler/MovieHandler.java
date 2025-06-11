package com.cinemaproject.appcore.Handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cinemaproject.appcore.Model.Movie;
import com.cinemaproject.appcore.Service.MovieService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MovieHandler {

    private final MovieService movieService;

    public MovieHandler(MovieService movieService) {
        this.movieService = movieService;
    }

    public Mono<ServerResponse> getMovies(ServerRequest request) {
        return ServerResponse.ok()
                .body(movieService.getAllMovies(), Movie.class);
    }

    public Mono<ServerResponse> addMovie(ServerRequest request){
        return ServerResponse.ok()
                .body(request.bodyToMono(Movie.class)
                .flatMap(movieService::addMovie), Movie.class);
    }

    public Mono<ServerResponse> getMoviesByName(ServerRequest request) {
        String name = request.pathVariable("name");
        Flux<Movie> movies = movieService.getMoviesByName(name);

        return movies
            .collectList()
            .flatMap(list -> {
                if (list.isEmpty()) {
                    return ServerResponse.notFound().build();
                } else {
                    return ServerResponse.ok().bodyValue(list);
                }
            });
    }


}
