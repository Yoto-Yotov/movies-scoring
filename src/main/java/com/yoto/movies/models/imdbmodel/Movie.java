package com.yoto.movies.models.imdbmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @JsonProperty("Ratings")
    List<Rating> ratings;

    @JsonProperty("Title")
    String title;
}
