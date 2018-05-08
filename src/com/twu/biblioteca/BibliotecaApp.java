package com.twu.biblioteca;

import Helpers.InputReader;
import Helpers.Printer;
import Helpers.Menu;

import Biblioteca.Biblioteca;
import Item.Book;

public class BibliotecaApp {

    private static Biblioteca biblioteca;

    public static void main(String[] args) {

        Printer printer = new Printer();

        biblioteca = new Biblioteca("The Bangalore Public Library", new InputReader(printer), printer, new Menu());
        addBooks(biblioteca);
        biblioteca.giveWelcome();
        biblioteca.init();

    }

    public static void addBooks(Biblioteca biblioteca){

        biblioteca.bookList.add(new Book("Living la vida loca", "Ricky Martin", 1989));
        biblioteca.bookList.add(new Book("What life is all about", "Spongebob squarepants", 2010));
        biblioteca.bookList.add(new Book("Something Random", "Kylie Jenner", 2018));
        biblioteca.bookList.add(new Book("Liv Tyler ", "Liv Tyler", 1980));

    }
}
