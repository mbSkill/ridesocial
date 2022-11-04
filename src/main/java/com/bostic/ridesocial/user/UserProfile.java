package com.bostic.ridesocial.user;

import com.bostic.ridesocial.park.Park;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserProfile extends User{

    String bio;
    String stance;
    String photo;
    @ManyToOne
    @JoinColumn(name = "favorite_park_address")
    Park favoritePark;
}
