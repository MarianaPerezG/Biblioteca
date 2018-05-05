package Biblioteca;

import java.util.ArrayList;
import Book.Book;

public class Biblioteca {

    private String name;
    private static final String WELCOME_MESSAGE = "Welcome to";

    public ArrayList<Book> bookList;

    public Biblioteca(String name){
        this.name = name;
    }

    public void giveWelcome(){
        System.out.println(WELCOME_MESSAGE + " " + name);
    }


}
