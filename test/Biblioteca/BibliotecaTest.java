package Biblioteca;

import Book.Book;
import Helpers.InputReader;
import Helpers.Messages;
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
    public void testThatGetBooksInListFindsABook(){

        ArrayList<Book> correctArray = new ArrayList<Book>();
        correctArray.add(book);

        assertEquals(biblioteca.getBooksInList("Te"), correctArray);
    }

    @Test
    public void testThatGetBooksListReturnsEmptyArrayListIfNotMatchFound(){
        ArrayList<Book> correctArray = new ArrayList<Book>();
        assertEquals(biblioteca.getBooksInList("Random String"), correctArray);
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

        assertEquals(biblioteca.printAvailableBookList(bookArray), 1);
    }

}