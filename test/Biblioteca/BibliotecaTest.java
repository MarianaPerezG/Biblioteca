package Biblioteca;

import Book.Book;
import Helpers.InputReader;
import Helpers.Messages;
import Helpers.Printer;
import Helpers.Menu;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class BibliotecaTest {

    public Biblioteca biblioteca;
    public Book book;

    @Before
    public void setUp() {
       biblioteca = new Biblioteca("Test", new InputReader(), new Printer(), new Menu());
       book = new Book("Test", "Test Author", 2018);
       biblioteca.bookList.add(book);
    }

}