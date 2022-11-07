package com.bostic.ridesocial.park.skatepark;

import com.bostic.ridesocial.park.Park;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skatepark extends Park {
    @Id
    @SerializedName(value = "name", alternate = "Name")
    String name;
    String description;
    @Column(name = "gx_media_links")
    @SerializedName(value = "gxMediaLinks", alternate = "gx_media_links")
    String gxMediaLinks = "";
    String latitude = "";
    String longitude= "";



    @Override
    public String toString() {
        return "Skatepark{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", gxMediaLinks='" + gxMediaLinks + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGxMediaLinks() {
        return gxMediaLinks;
    }

    public void setGxMediaLinks(String gxMediaLinks) {
        this.gxMediaLinks = gxMediaLinks;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setCoordinates(String[] coord){
        if (coord.length == 2){
        latitude = coord[0];
        longitude = coord[1];
        }
    }
}
