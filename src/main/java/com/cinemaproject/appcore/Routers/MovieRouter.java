package com.cinemaproject.appcore.Routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cinemaproject.appcore.Handler.MovieHandler;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MovieRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(MovieHandler movieHandler) {
        return route(GET("/api/movies"), movieHandler::getMovies)
                .andRoute(POST("/api/movies"), movieHandler::addMovie);
    }

}
