package com.yoto.movies.controllers.rest;

import com.yoto.movies.exceptions.MovieNotFoundException;
import com.yoto.movies.models.imdbmodel.Movie;
import com.yoto.movies.services.contracts.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class MovieControllerRest {

    MovieService movieService;

    @Autowired
    public MovieControllerRest(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi";
    }

    @GetMapping("/movie")
    public Movie getMovie(@RequestParam("id") String movieId) {
        try {
            return movieService.getMovieInfo(movieId);
        } catch (MovieNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found", e);
        }
    }

}
