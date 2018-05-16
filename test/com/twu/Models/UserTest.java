package com.twu.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    public User user;

    public void aUser(){
        user = new User("Mariana", "Perez", "123-123", "password", "mperez@email.com", "555-55-55", false);
    }

    @Test
    public void shouldReturnUserInformationCorrectly(){
//        given
        aUser();
//        when
        String returnedString = user.getInfo();
        String correctString = "Name: Mariana Perez email: mperez@email.com phone: 555-55-55";
//        then
        assertEquals(returnedString, correctString);

    }

    @Test
    public void shouldReturnTrueIfPasswordIsCorrect(){
//        given
        aUser();
        String passwordToCheck = "password";
//        when
        boolean passwordCorrect = user.isPasswordCorrect(passwordToCheck);
//        then
        assertTrue(passwordCorrect);

    }

    @Test
    public void shouldReturnFalseIfPasswordIsIncorrect(){
//        given
        aUser();
        String passwordToCheck = "falsePassword";
//        when
        boolean passwordCorrect = user.isPasswordCorrect(passwordToCheck);
//        then
        assertFalse(passwordCorrect);
    }

}