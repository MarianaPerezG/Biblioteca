package com.twu.Helpers;

import com.twu.Models.User;
import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.BibliotecaManager;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticatorTest {

    public User user;
    public InputReader inputreader;
    public String input;
    public Biblioteca biblioteca;
    public BibliotecaManager bibliotecaManager;
    public Printer printer;
    public Authenticator authenticator;

    @Before
    public void setUp() {

        printer = new Printer();
        biblioteca = new Biblioteca("Test");
        bibliotecaManager = new BibliotecaManager(biblioteca, printer);
        authenticator = new Authenticator(bibliotecaManager);

    }

    public void bibliotecaWithUser(){
        user = new User("Mariana", "Perez","123-123","password", "mperez@prueba.com", "555-55-55", false );
        biblioteca.getUserList().add(user);
    }

    @Test
    public void shouldAllowLogInOfUserIfUserExistAndThePasswordIsCorrect(){
//        given
        bibliotecaWithUser();
//        when
        String libraryNumberCollected = "123-123";
        String passwordCollected = "password";
        boolean returned = authenticator.giveAccess(libraryNumberCollected, passwordCollected );
//        then
        assertTrue(returned);
    }

    @Test
    public void shouldReturnUserIfLibraryNumberExist(){
//        given
        bibliotecaWithUser();
//        when
        String libraryNumberCollected = "123-123";
        User returned = authenticator.getUserWithLibraryNumber(libraryNumberCollected, bibliotecaManager.getBiblioteca().getUserList());
//        then
        assertThat(returned, instanceOf(User.class));

    }

    @Test
    public void shouldReturnTrueIfPasswordIsCorrect(){
//        given
        bibliotecaWithUser();
//        when
        String password = "password";
        boolean returned = authenticator.passwordIsCorrectForUser(password, user);
//        then
        assertTrue(returned);

    }

    @Test
    public void shouldAssignTheCurrentUserCorrectly(){
//        given
        bibliotecaWithUser();
//        when
        String libraryNumberCollected = "123-123";
        String passwordCollected = "password";
        boolean returned = authenticator.giveAccess(libraryNumberCollected, passwordCollected );
        User correctUserLogedIn = user;
        User userAssignedToManager = bibliotecaManager.getLoggedUser();
//        then
        assertTrue(returned);
        assertEquals(correctUserLogedIn,userAssignedToManager);

    }

}