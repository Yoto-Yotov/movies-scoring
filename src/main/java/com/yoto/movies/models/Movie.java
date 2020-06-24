package com.yoto.movies.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

    private String name;
    private int rating;

}
