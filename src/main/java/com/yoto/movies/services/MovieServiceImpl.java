package com.yoto.movies.services;

import com.yoto.movies.services.contracts.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieServiceImpl implements MovieService {

    @Override
    public int getMovieAvrgRating(String imdbMovieId) {
        RestTemplate restTemplate = new RestTemplate();

        return 0;
    }
}
