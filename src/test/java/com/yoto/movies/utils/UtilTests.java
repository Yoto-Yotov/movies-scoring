package com.yoto.movies.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTests {

    @Test
    public void parseUrl_Should_ReturnAccurateUrl_When_ImdbIdIsPassed() {
        //Arrange
        //Act
        String resultUrl = UrlParser.parseUrl("tt0944947");

        //Assert
        Assertions.assertEquals("http://www.omdbapi.com/?apikey=" + System.getenv("OMDB_APIKEY") + "&i=tt0944947", resultUrl);
    }

}
