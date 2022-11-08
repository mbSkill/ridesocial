package com.bostic.ridesocial.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupServiceTest {
    SignupService signupService = new SignupService();
    @Test
    @DisplayName("has email postfix")
    void userEmailHasCorrectPostfix(){
        assertTrue(signupService.validateEmail("cool@cool.com"));
        assertFalse(signupService.validateEmail("cool"));
        assertFalse(signupService.validateEmail("cool@"));
    }

    @Test
    @DisplayName("")

}