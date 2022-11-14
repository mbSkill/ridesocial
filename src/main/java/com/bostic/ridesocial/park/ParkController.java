package com.bostic.ridesocial.park;

import com.bostic.ridesocial.park.skatepark.Skatepark;
import com.bostic.ridesocial.park.skatepark.SkateparkRepository;
import com.bostic.ridesocial.util.CalculateDistance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController("skatepark/")
public class ParkController {
    SkateparkRepository skateparkRepository;

    public ParkController(SkateparkRepository skateparkRepository) {
        this.skateparkRepository = skateparkRepository;
    }

    @GetMapping
    public ResponseEntity<List<Skatepark>> getSkateparksByCoord(@RequestParam("lat") String lat,
                                                               @RequestParam("lon") String lon){
        List<Skatepark> skateparks;
        double latitude, longitude;
        try{
            latitude = Double.parseDouble(lat);
            longitude = Double.parseDouble(lon);
            skateparks = skateparkRepository.findAll();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                skateparks.stream().sorted(
                Comparator.comparingDouble(x ->
                        CalculateDistance.distance(latitude, longitude,
                                Double.parseDouble(x.getLatitude()), Double.parseDouble(x.getLongitude()))
                )).collect(Collectors.toList()),
                HttpStatus.ACCEPTED);

    }
}
