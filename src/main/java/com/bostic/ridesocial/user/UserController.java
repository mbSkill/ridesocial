package com.bostic.ridesocial.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @PostMapping("/signup")
    public ResponseEntity<String> signup(User user){
        return new ResponseEntity<>("cool", HttpStatus.ACCEPTED);
    }
}
