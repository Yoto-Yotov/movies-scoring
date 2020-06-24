package com.yoto.movies.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieControllerRest {

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi";
    }

}
