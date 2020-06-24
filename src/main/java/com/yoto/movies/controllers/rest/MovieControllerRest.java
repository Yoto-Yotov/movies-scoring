package com.yoto.movies.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieControllerRest {

    @GetMapping
    public String sayHi() {
        return System.getenv("OMDB_APIKEY");
    }

}
