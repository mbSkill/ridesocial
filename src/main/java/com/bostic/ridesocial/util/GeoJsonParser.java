package com.bostic.ridesocial.util;

import com.bostic.ridesocial.park.skatepark.GeojsonSkatepark;
import com.bostic.ridesocial.park.skatepark.Skatepark;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeoJsonParser {
    static Logger logger = Logger.getLogger(GeoJsonParser.class);

    static Gson gson =  new Gson();
    static ObjectMapper mapper = new ObjectMapper();


    public static List<Skatepark> parseFromFile(String file) throws IOException {
        gson.newBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
        // Read json file and map results to GeojsonSkatepark.class
        var fromJson = gson.fromJson(new FileReader(
                "src/main/resources/geodata/Colorado_Skatepark_Directory__SpeakEasySkate.com/SKATEPARKS.geojson"),
                GeojsonSkatepark.class);

        //pull the coordinates from outer object into each skatepark object
        //map and collect just the Skatepark objects.
        return fromJson.getFeatures()
                .stream()
                .peek(park -> park.getSkatepark()
                        .setCoordinates(park.getCoordinates()))
                .map(GeojsonSkatepark.Features::getSkatepark)
                .collect(Collectors.toList());

    }
}
