package com.yoto.movies.exceptions;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String param, String value) {
        super(String.format("Movie with %s %s does not exist", param, value));
    }
}
