package com.bostic.ridesocial.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SignupServiceTest {
    @Autowired SignupService signupService;
    @Autowired UserRepository repository;

    User user = new User();

    @Test
    @DisplayName("has email postfix")
    void userEmailHasCorrectPostfix(){
        assertTrue(signupService.validateEmail("cool@cool.com"));
        assertFalse(signupService.validateEmail("cool"), "Missing both @ and .");
        assertFalse(signupService.validateEmail("cool@"), "Missing domain.com");
    }

    @Test
    @DisplayName("is email account already registered")
    void checkForEmailInDatabase(){
        user.setEmail("me@me.com");
        assertTrue(
                repository.existsById("me@me.com"));
        assertFalse(
                repository.existsById("SLK@j.com"));
    }

}