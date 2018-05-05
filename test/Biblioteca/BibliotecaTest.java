package Biblioteca;

import Book.Book;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class BibliotecaTest {

    public Biblioteca biblioteca;

    @Before
    public void setUp() {
       biblioteca = new Biblioteca("Test");
       biblioteca.bookList.add(new Book("Test", "Test Author", 2018));
    }

    @Test
    public void checkIfCheckoutABookCorrectlyReturnsTrue(){

        assertEquals(biblioteca.checkOut("Test", true));
    }

}