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
        //requires one uppercase/lowercase/numeric/no whitespace
        //and at least one symbol from [!@#$%] with a length of 8-32
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%])(?!.*\\s).{8,32}");
    }

    boolean isUniqueUsername(String username){
        return username.isBlank() ? Boolean.FALSE :
                repository.existsByUsername(username);
    }

    public User saveNewUser(User user){
        /**
         * TODO: check if username exists
         **/
        return new User();
    }
}
