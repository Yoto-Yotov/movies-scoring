package com.yoto.movies.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicMovie {

    private String name;
    private double rating;

}
