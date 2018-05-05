package com.twu.biblioteca;

import Biblioteca.Biblioteca;
import Book.Book;

public class BibliotecaApp {

    private static Biblioteca biblioteca;

    public static void main(String[] args) {

        biblioteca = new Biblioteca("The Bangalore Public Library");
        addBooks(biblioteca);
        biblioteca.giveWelcome();
        biblioteca.init();


    }

    public static void addBooks(Biblioteca biblioteca){

        biblioteca.bookList.add(new Book("Living la vida loca", "Ricky Martin", 1989));
        biblioteca.bookList.add(new Book("What life is all about", "Spongebob squarepants", 2010));
        biblioteca.bookList.add(new Book("Something Random", "Kylie Jenner", 2018));

    }
}
