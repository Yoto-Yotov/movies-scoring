package com.yoto.movies.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoto.movies.models.imdbmodel.Movie;
import com.yoto.movies.services.contracts.MovieService;
import com.yoto.movies.utils.UrlParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieServiceImpl implements MovieService {

    @Override
    public int getMovieAvrgRating(String imdbMovieId) {
        RestTemplate restTemplate = new RestTemplate();

        String resultUrl = UrlParser.parseUrl(imdbMovieId);

        return 0;
    }

    @Override
    public Movie getMovieInfo(String imdbMovieId) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String resultUrl = UrlParser.parseUrl(imdbMovieId);

        ResponseEntity<String> response = restTemplate.getForEntity(resultUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        if(root.has("Error")) {
            //to do throw exception 
        }

        return restTemplate.getForObject(resultUrl, Movie.class);
    }


}
