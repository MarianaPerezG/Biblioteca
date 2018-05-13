package com.twu.biblioteca;

import com.twu.Item.Book;
import com.twu.Helpers.InputReader;
import com.twu.Helpers.Printer;
import com.twu.Helpers.Menu;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

public class BibliotecaTest {

    public Biblioteca biblioteca;
    public Book book;

    @Before
    public void setUp() {

        biblioteca = new Biblioteca("Test");
        book = new Book("Test", "Test Author", 2018);
        biblioteca.getBookList().add(book);
    }

    @Test
    public void shouldReturnWelcomeMessageWithName(){

        assertEquals(biblioteca.welcomeMessage(), "Test");
    }

    @Test
    public void testThatGetBooksInListFindsABookThatAvailable(){

        ArrayList<Book> correctArray = new ArrayList<Book>();
        correctArray.add(book);

        assertEquals(biblioteca.getBooksMatchingInList("Te", true), correctArray);
    }

    @Test
    public void testThatGetBooksListReturnsEmptyArrayListIfNotMatchFoundAvailable(){
        ArrayList<Book> correctArray = new ArrayList<Book>();
        assertEquals(biblioteca.getBooksMatchingInList("Random String", true), correctArray);
    }

    @Test
    public void testThatGetBooksInListFindsABookThatNotAvailable(){

        ArrayList<Book> correctArray = new ArrayList<Book>();
        book.checkOut();
        correctArray.add(book);

        assertEquals(biblioteca.getBooksMatchingInList("Te", false), correctArray);
    }



}