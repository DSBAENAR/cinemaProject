package com.cinemaproject.appcore.Routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cinemaproject.appcore.Handler.MovieHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;

@Configuration
public class MovieRouter {
    /**
     * Configures the OpenAPI documentation for the movie-related endpoints.
     * This includes paths, methods, and responses for each endpoint.
     */
    @RouterOperations({
    @RouterOperation(
        path = "/api/movies",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.GET,
        beanClass = MovieHandler.class,
        beanMethod = "getMovies",
        operation = @Operation(
            operationId = "getMovies",
            summary = "Get all movies",
            responses = {
                @ApiResponse(responseCode = "200", description = "List of movies")
            }
        )
    ),
    @RouterOperation(
        path = "/api/movies/{name}",
        method = RequestMethod.GET,
        beanClass = MovieHandler.class,
        beanMethod = "getMoviesByName",
        operation = @Operation(
            operationId = "getMovieByName",
            summary = "Find movie by name",
            parameters = {
                @Parameter(name = "name", in = ParameterIn.PATH, required = true)
            },
            responses = {
                @ApiResponse(responseCode = "200", description = "Movie found"),
                @ApiResponse(responseCode = "404", description = "Movie not found")
            }
        )
    )
    ,
    @RouterOperation(
        path = "/api/movies",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        method = RequestMethod.POST,
        beanClass = MovieHandler.class,
        beanMethod = "addMovie",
        operation = @Operation(
            operationId = "addMovie",
            summary = "Add a new movie",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Movie object to be added",
                content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = com.cinemaproject.appcore.Model.Movie.class)
                )
            ),
            responses = {
                @ApiResponse(responseCode = "200", description = "Movie added successfully")
            }
        )
    )
})

    /**
     * Defines the routes for movie-related operations.
     *
     * @param movieHandler the handler for movie operations.
     * @return a RouterFunction that maps requests to the appropriate handler methods.
     */
    @Bean
    public RouterFunction<ServerResponse> routes(MovieHandler movieHandler) {
        return route(GET("/api/movies"), movieHandler::getMovies)
                .andRoute(POST("/api/movies"), movieHandler::addMovie)
                .andRoute(GET("/api/movies/{name}"), movieHandler::getMoviesByName);
    }

}
