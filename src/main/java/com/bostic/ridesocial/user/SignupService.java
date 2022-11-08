package com.bostic.ridesocial.user;

import org.springframework.stereotype.Service;

@Service
public class SignupService {
    UserRepository repository;

    private boolean validateEmail(String email){
        return true;
    }

    private boolean emailExists(String email){
        return true;
    }

    private boolean validatePassword(){
        return true;
    }

    private boolean isUniqueUsername(){
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
