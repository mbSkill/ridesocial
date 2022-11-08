package com.bostic.ridesocial.user;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class SignupService {
    UserRepository repository;

    boolean validateEmail(String email){
        String regex = "^" +
                "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]" +
                "+@" +
                "[a-zA-Z0-9.-]" +
                "+$";

        var RFCemailPattern = Pattern.compile(regex);
        var matcher = RFCemailPattern.matcher(email);
        return matcher.matches();
    }

    boolean emailExists(String email){
        return repository.existsById(email);
    }

    boolean validatePassword(String password){

        String regex = "^" +
                "(?=.*[0-9])" +
                "(?=.*[a-z])" +
                "(?=.*[A-Z])" +
                "(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\])" +
                ".{8,32}$";

        var passwordStandards = Pattern.compile(regex);
        var matcher = passwordStandards.matcher(password);
        return matcher.matches();
    }

    boolean isUniqueUsername(){
        return true;
    }

    public User saveNewUser(User user){
        /**
         * TODO: check if username exists
         **/
        return new User();
    }
}
