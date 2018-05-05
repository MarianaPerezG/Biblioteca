package Biblioteca;

import Book.Book;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class BibliotecaTest {

    public Biblioteca biblioteca;
    public Book book;

    @Before
    public void setUp() {
       biblioteca = new Biblioteca("Test");
       book = new Book("Test", "Test Author", 2018);
       biblioteca.bookList.add(book);
    }

    @Test
    public void checkIfCheckoutABookCorrectlyReturnsTrue(){

        assertEquals(biblioteca.checkOut(book), true);
    }

}