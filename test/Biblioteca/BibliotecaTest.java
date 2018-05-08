package Biblioteca;

import Item.Book;
import Helpers.InputReader;
import Helpers.Printer;
import Helpers.Menu;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

public class BibliotecaTest {

    public Biblioteca biblioteca;
    public Book book;

    @Before
    public void setUp() {

        Printer printer;
        printer = new Printer();

        biblioteca = new Biblioteca("Test", new InputReader(printer), printer , new Menu());
        book = new Book("Test", "Test Author", 2018);
        biblioteca.bookList.add(book);
    }

    @Test
    public void testThatGetBooksInListFindsABookThatAvailable(){

        ArrayList<Book> correctArray = new ArrayList<Book>();
        correctArray.add(book);

        assertEquals(biblioteca.getBooksInList("Te", true), correctArray);
    }

    @Test
    public void testThatGetBooksListReturnsEmptyArrayListIfNotMatchFoundAvailable(){
        ArrayList<Book> correctArray = new ArrayList<Book>();
        assertEquals(biblioteca.getBooksInList("Random String", true), correctArray);
    }

    @Test
    public void testThatGetBooksInListFindsABookThatNotAvailable(){

        ArrayList<Book> correctArray = new ArrayList<Book>();
        book.markTaken();
        correctArray.add(book);

        assertEquals(biblioteca.getBooksInList("Te", false), correctArray);
    }

    @Test
    public void testIfAnAvailableBookCanBeCheckedOut(){
        assertEquals(biblioteca.checkOut(book), true);
    }

    @Test
    public void testIfAnUnavailableCantBeCheckedOut(){
        book.markTaken();
        assertEquals(biblioteca.checkOut(book), false);

    }

    @Test
    public void testIfPrintBooksListPrintsOnlyTheAvailable(){

        ArrayList<Book> bookArray = new ArrayList<Book>();
        book.markTaken();
        bookArray.add(book);
        bookArray.add(new Book("Test2", "Mariana Perez", 1989));

        assertEquals(biblioteca.printBookList(bookArray, true), 1);
    }

}