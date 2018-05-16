package com.twu.Helpers;

import com.twu.Models.User;
import com.twu.biblioteca.BibliotecaManager;

import java.util.ArrayList;

public class Authenticator {

    private BibliotecaManager bibliotecaMan;

    public Authenticator(BibliotecaManager bibliotecaMan) {
        this.bibliotecaMan = bibliotecaMan;
    }


    public boolean giveAccess(String libraryNumber, String password) {

        User userToLogin = getUserWithLibraryNumber(libraryNumber, bibliotecaMan.getBiblioteca().getUserList());

        if( userToLogin != null){

            if(passwordIsCorrectForUser(password, userToLogin)){
                bibliotecaMan.assignUser(userToLogin);
                return true;
            }

        }

        return false;
    }


    public boolean passwordIsCorrectForUser(String password, User userToLogin) {

        return userToLogin.isPasswordCorrect(password);
    }

    public User getUserWithLibraryNumber(String libraryNumber, ArrayList<User> users) {

        for(User user:users){
            if(user.getLibraryNumber().equals(libraryNumber)){
                return user;
            }
        }

        return null;
    }
}
