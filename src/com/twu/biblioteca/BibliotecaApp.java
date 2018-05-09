package com.twu.biblioteca;

import Helpers.InputReader;
import Helpers.Printer;
import Helpers.Menu;

import Item.Book;
import Item.Movie;

public class BibliotecaApp {

    private static Biblioteca biblioteca;

    public static void main(String[] args) {

        Printer printer = new Printer();

        biblioteca = new Biblioteca("The Bangalore Public Library", new InputReader(printer), printer, new Menu());
        addDB(biblioteca);
        biblioteca.giveWelcome();
        biblioteca.init();

    }

    public static void addDB(Biblioteca biblioteca){

        biblioteca.bookList.add(new Book("Living la vida loca", "Ricky Martin", 1989));
        biblioteca.bookList.add(new Book("What life is all about", "Spongebob squarepants", 2010));
        biblioteca.bookList.add(new Book("Something Random", "Kylie Jenner", 2018));
        biblioteca.bookList.add(new Book("Liv Tyler Bio ", "Liv Tyler", 1980));

        biblioteca.movieList.add(new Movie("50 first Dates", "Peter Segal", 2004, 5.0f));
        biblioteca.movieList.add(new Movie("Random", "Mariana Perez", 2018, 2.0f));

    }
}
