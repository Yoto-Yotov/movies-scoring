package com.yoto.movies.services.contracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yoto.movies.models.BasicMovie;
import com.yoto.movies.models.imdbmodel.Movie;

public interface MovieService {

    BasicMovie getBasicMovie(String imdbMovieId);
    Movie getMovieInfo(String imdbMovieId);

}
