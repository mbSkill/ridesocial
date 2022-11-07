package com.bostic.ridesocial.util;

import com.bostic.ridesocial.park.skatepark.Skatepark;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GeoJsonParserTest {
    String path =
            "src/main/resources/geodata/Colorado_Skatepark_Directory__SpeakEasySkate.com/SKATEPARKS.geojson";

    @Test
    @DisplayName("Has only Skatepark objects")

    void parseFromFile() throws IOException {
        var list = GeoJsonParser.parseFromFile(path);
        list.forEach(park ->
                assertInstanceOf(Skatepark.class, park)
        );
    }

    @Test
    @DisplayName("Each object has a name")
    void skateparkHasName() throws IOException {
        var list = GeoJsonParser.parseFromFile(path);
        list.forEach(skatepark ->
                assertNotNull(skatepark.getName())
        );
    }

    @Test
    @DisplayName("Each Object has a description")
    void skateparkHasDiscription() throws IOException {
        var list = GeoJsonParser.parseFromFile(path);
        list.forEach(skatepark ->
                assertNotNull(skatepark.getDescription())
        );
    }

}