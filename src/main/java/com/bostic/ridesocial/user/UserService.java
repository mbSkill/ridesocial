package com.bostic.ridesocial.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    boolean validateEmail(String email){
        String regex = "^" +
                "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]" +
                "+@" +
                "[a-zA-Z0-9.-]" +
                "+$";
        return email.matches(regex);
    }

    public boolean emailExists(String email){
        return repository.existsById(email);
    }

    boolean validatePassword(String password){
        //requires one uppercase/lowercase/numeric/no whitespace
        //and at least one symbol from [!@#$%] with a length of 8-32
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%])(?!.*\\s).{8,32}");
    }

    boolean isUniqueUsername(String username){
        return username.isBlank() ? Boolean.FALSE :
                !repository.existsByUsername(username);
    }

    public User saveNewUser(User user){
        if(validateEmail(user.getEmail()) &&
            !emailExists(user.getEmail()) &&
            validatePassword(user.getPassword()) &&
            isUniqueUsername(user.getUsername())){
            return repository.save(user);
        }
        return new User();
    }

    public Optional<User> getUser(String email) {
        return repository.findById(email);
    }
}
