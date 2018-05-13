package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaSystemTest {

    public Biblioteca biblioteca;
    public BibliotecaSystem  bibliotecaSys;
    public Book book;
    public Printer printer;
    public InputReader inputreader;

    @Before
    public void setUp() {

        printer = new Printer();

        biblioteca = new Biblioteca("Test");
        book = new Book("Test", "Test Author", 2018);
        biblioteca.getBookList().add(book);
        bibliotecaSys = new BibliotecaSystem(biblioteca, printer);

    }

    @Test
    public void testIfAnAvailableBookCanBeCheckedOut(){
        assertEquals(bibliotecaSys.checkOut(book), true);
    }

    @Test
    public void testIfAnUnavailableCantBeCheckedOut(){
        book.checkOut();
        assertEquals(bibliotecaSys.checkOut(book), false);

    }

}