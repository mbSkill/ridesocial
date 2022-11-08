package com.bostic.ridesocial.user;

import com.bostic.ridesocial.park.Park;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class UserProfile {

    String bio;
    String stance;
    String photo;
}
