package com.yoto.movies.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoto.movies.exceptions.MovieNotFoundException;
import com.yoto.movies.models.BasicMovie;
import com.yoto.movies.models.imdbmodel.Movie;
import com.yoto.movies.models.imdbmodel.Rating;
import com.yoto.movies.services.contracts.MovieService;
import com.yoto.movies.utils.UrlParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImpl implements MovieService {

    @Override
    public BasicMovie getBasicMovie(String imdbMovieId) {
        RestTemplate restTemplate = new RestTemplate();

        Movie movie = getMovieInfo(imdbMovieId);
        BasicMovie basicMovieResult = mapMovieToBasicMovie(movie);

        return basicMovieResult;
    }

    private BasicMovie mapMovieToBasicMovie(Movie movie) {
        double rating = -1;

        if(!movie.getRatings().isEmpty()) {
            rating = calculateAverageRating(movie.getRatings());
        }

        return new BasicMovie(movie.getTitle(), rating);
    }

    private double calculateAverageRating(List<Rating> ratings) {
        double mediumRating = 0;

        for (Rating rating : ratings) {
            mediumRating += Double.parseDouble(rating.getValue().substring(0,3).replaceAll("[^\\d]", ""));
        }

        mediumRating = mediumRating / ratings.size();
        return Double.parseDouble(String.format("%.2f", mediumRating));
    }

    @Override
    public Movie getMovieInfo(String imdbMovieId) {
        RestTemplate restTemplate = new RestTemplate();
        String resultUrl = UrlParser.parseUrl(imdbMovieId);

        ResponseEntity<String> response = restTemplate.getForEntity(resultUrl, String.class);

        mapResponseToString(response, imdbMovieId);

        return restTemplate.getForObject(resultUrl, Movie.class);
    }

    private static void mapResponseToString(ResponseEntity<String> response, String imdbMovieId) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(Objects.requireNonNull(response.getBody()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        validateResponse(imdbMovieId, root);
    }

    private static void validateResponse(String imdbMovieId, JsonNode root) {
        if(root.has("Error")) {
            throw new MovieNotFoundException("id", imdbMovieId);
        }
    }


}
