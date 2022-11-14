package com.bostic.ridesocial.util;

import org.springframework.stereotype.Service;

@Service
public class CalculateDistance {

    public static double distance(double userLat, double userLon, double parkLat, double parkLon) {
        if((userLat == parkLat) && (userLon == parkLon)) {
            return 0;
        }else {
            double theta = userLon - parkLon;
            double distance = Math.sin(Math.toRadians(userLat)) * Math.sin((Math.toRadians(parkLat)))
                    + Math.cos(Math.toRadians(userLat)) * Math.cos((Math.toRadians(parkLat)))
                    * Math.cos(Math.toRadians(theta));
            distance = Math.acos(distance);
            distance = Math.toDegrees(distance);
            distance = distance * 60 * 1.1515;
            return distance;
        }
    }

}
