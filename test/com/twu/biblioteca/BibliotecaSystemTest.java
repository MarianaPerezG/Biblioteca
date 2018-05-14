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
    public Movie movie;
    public Printer printer;
    public InputReader inputreader;

    @Before
    public void setUp() {

        printer = new Printer();

        biblioteca = new Biblioteca("Test");
        book = new Book("Test", "Test Author", 2018);
        movie = new Movie("Test Movie", "Test director", 2018, 5.0f);
        biblioteca.getBookList().add(book);
        bibliotecaSys = new BibliotecaSystem(biblioteca, printer);
        biblioteca.getMovieList().add(movie);

    }

    @Test
    public void shouldCheckOutAnAvailableBook(){
        assertEquals(bibliotecaSys.checkOut(book), true);
    }

    @Test
    public void shouldNotCheckOutIfAnUnavailableBook(){
        book.checkOut();
        assertEquals(bibliotecaSys.checkOut(book), false);

    }

    @Test
    public void shouldCheckOutIfAnAvailableMovie(){
        assertEquals(bibliotecaSys.checkOut(movie), true);
    }

    @Test
    public void shouldNotCheckOutIfAnUnavailableMovie(){
        movie.checkOut();
        assertEquals(bibliotecaSys.checkOut(movie), false);
    }

    @Test
    public void shouldNotAllowCheckOutIfNotMatchingBook(){

        assertEquals(bibliotecaSys.manageResponseToCheckoutBook("Random"), false);

    }

    @Test
    public void shouldAllowCheckOutIfNotMatchingBook(){

        assertEquals(bibliotecaSys.manageResponseToCheckoutBook("Test"), true);
        assertEquals(book.isAvailable(), false);

    }

    @Test
    public void shouldNotAllowCheckOutIfNotMatchingMovie(){

        assertEquals(bibliotecaSys.manageResponseToCheckoutMovie("Random"), false);

    }

    @Test
    public void shouldAllowCheckOutIfNotMatchingMovie(){

        assertEquals(bibliotecaSys.manageResponseToCheckoutMovie("Test"), true);
        assertEquals(movie.isAvailable(), false);

    }

}