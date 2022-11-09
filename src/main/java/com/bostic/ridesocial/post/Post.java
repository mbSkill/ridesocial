package com.bostic.ridesocial.post;

import com.bostic.ridesocial.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_email")
    User user;
    String image;
    String paragraph;
    Timestamp createdOn;

}
