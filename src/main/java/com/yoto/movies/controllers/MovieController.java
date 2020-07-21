package com.yoto.movies.controllers;

import com.yoto.movies.models.BasicMovie;
import com.yoto.movies.services.contracts.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("movie", new BasicMovie("Star Wars", 5));
        return "index";
    }

    @GetMapping("/home/search")
    public String showMovieAverageRating(@RequestParam("movieId") String movieId, Model model) {
        model.addAttribute("movie", movieService.getBasicMovie(movieId));
        return "index";
    }
}
