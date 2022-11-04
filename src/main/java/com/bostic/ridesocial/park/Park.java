package com.bostic.ridesocial.park;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Park {
    @Id
    String address;
    String state;
    String city;
    String zip;
}
