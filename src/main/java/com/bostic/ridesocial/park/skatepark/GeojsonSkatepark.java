package com.bostic.ridesocial.park.skatepark;

import com.google.gson.annotations.Expose;

import java.util.Arrays;
import java.util.LinkedList;

public class GeojsonSkatepark {
   @Expose
   LinkedList<Features> features;

    @Override
    public String toString() {
        return "GeojsonSkatepark{" +
                "features=" + features +
                '}';
    }

    public LinkedList<Features> getFeatures() {
        return features;
    }

    public void setFeatures(LinkedList<Features> features) {
        this.features = features;
    }

    public class Features {
        Skatepark properties;
        Geometry geometry;

        @Override
        public String toString() {
            return "Features{" +
                    "properties=" + properties +
                    ", geometry=" + geometry +
                    '}';
        }

        public Skatepark getSkatepark(){
            return properties;
        }

        public String[] getCoordinates(){
            return geometry.getCoordinates();
        }

        public class Geometry{
            String[] coordinates;

            public String[] getCoordinates() {
                return coordinates;
            }

            @Override
            public String toString() {
                return "Geometry{" +
                        ", coordinates='" + Arrays.toString(coordinates) + '\'' +
                        '}';
            }
        }

    }
}
