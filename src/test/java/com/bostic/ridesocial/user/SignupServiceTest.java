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

    @Test
    @DisplayName("Check that password has one or more:" +
            "number, lowercase, uppercase, special character with a length between 8-32")
    void passwordValidator(){
        assertTrue(signupService.validatePassword("Th1zP@zzWorks!"), "Valid password");
        assertFalse(signupService.validatePassword("NoSymbolInPhrase1"),"No symbol characters");
        assertFalse(signupService.validatePassword("NoDiget@inPhrase"),"No digit in String");
        assertFalse(signupService.validatePassword("NoDiget@inPhrase"),"No digit in String");
        assertFalse(signupService.validatePassword("1234@#$%"),"No letters in Phrase");
        assertFalse(signupService.validatePassword("eE1!"),
                "Password is shorter than 8 characters but meets other requirements");
        assertFalse(signupService.validatePassword("ThisPassWillBeToLong*#*JkNBELKMSNLSkdsaj"),
                "Password is longer than 32 characters but meets other requirements");
    }

    @Test
    @DisplayName("Does the username already exist")
    void isUsernameInDatabase(){
        assertTrue(repository.existsByUsername("uname"));
        assertFalse(repository.existsByUsername(""));
    }

}