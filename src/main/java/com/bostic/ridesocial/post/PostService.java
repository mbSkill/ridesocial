package com.bostic.ridesocial.post;

import com.bostic.ridesocial.user.UserService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PostService {
    /**n
     * TODO: save image to Bucket
     * TODO: attach user email to establish post ownership
     */
    PostRepository repository;
    UserService userService;


    public PostService(PostRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Timestamp getDateTimeNow(){
        return Timestamp.valueOf(LocalDateTime.now());
    }

    public boolean ParagraphValidation(String paragraph){
        return paragraph.length() >= 300;
    }

    public boolean userEmailExists(String email){
       return !email.isBlank() && userService.emailExists(email);
    }
}
