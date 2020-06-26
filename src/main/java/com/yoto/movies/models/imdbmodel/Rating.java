package com.yoto.movies.models.imdbmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {

    @JsonProperty("Source")
    String source;

    @JsonProperty("Value")
    String value;
}
