package com.bostic.ridesocial.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user){
        User newUser = userService.saveNewUser(user);
        if(newUser != null){
            newUser.setPassword("");
            return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signIn")
    public ResponseEntity<User> signin(@RequestBody User user){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
