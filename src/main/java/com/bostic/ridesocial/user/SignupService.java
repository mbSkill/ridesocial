package com.bostic.ridesocial.user;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class SignupService {
    UserRepository repository;

    boolean validateEmail(String email){
        var RFCemailPattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        var matcher = RFCemailPattern.matcher(email);
        return matcher.matches();
    }

    boolean emailExists(String email){
        return repository.existsById(email);
    }

    boolean validatePassword(){
        return true;
    }

    boolean isUniqueUsername(){
        return true;
    }

    public User saveNewUser(User user){
        /**
         * TODO: validate format of email
         * TODO: Check if email exists
         * TODO: validate password matches requirements
         * TODO: check if username exists
         **/
        return new User();
    }
}
