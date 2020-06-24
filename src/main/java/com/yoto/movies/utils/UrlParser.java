package com.yoto.movies.utils;

import org.springframework.core.env.Environment;

public class UrlParser {

    private static final String OMDB_LINK = "http://www.omdbapi.com/?apikey=";

    public static String parseUrl(String imdbMovieId) {
        StringBuilder sb = new StringBuilder();
        sb.append(OMDB_LINK);
        sb.append(System.getenv("OMDB_APIKEY"));
        sb.append("&i=");
        sb.append(imdbMovieId);
        return sb.toString();
    }

}
