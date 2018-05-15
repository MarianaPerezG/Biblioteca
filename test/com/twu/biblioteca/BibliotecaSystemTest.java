package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Models.*;
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
    public String input;

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
        assertEquals(bibliotecaSys.manageBookCheckOut(book.getName()), true);
    }

    @Test
    public void shouldNotCheckOutIfAnUnavailableBook(){
        book.setCheckedOut();
        assertEquals(bibliotecaSys.manageBookCheckOut(book.getName()), false);

    }

    @Test
    public void shouldNotCheckOutIfAnUnavailableMovie(){
        //given

        //when
        movie.setCheckedOut();

        //then
        assertEquals(bibliotecaSys.manageMovieCheckOut(movie.getName()), false);
    }

        @Test
    public void shouldNotAllowCheckOutIfNotMatchingBook(){

        assertEquals(bibliotecaSys.manageBookCheckOut("Random"), false);

    }

    @Test
    public void shouldAllowCheckOutIfNotMatchingBook(){

        assertEquals(bibliotecaSys.manageBookCheckOut("Test"), true);
        assertEquals(book.isAvailable(), false);

    }

    @Test
    public void shouldNotAllowCheckOutIfNotMatchingMovie(){

        assertEquals(bibliotecaSys.manageMovieCheckOut("Random"), false);

    }

    @Test
    public void shouldAllowCheckOutIfMatchingMovie(){

        assertEquals(movie.isAvailable(), true);
        assertEquals(bibliotecaSys.manageMovieCheckOut("Test"), true);
        assertEquals(movie.isAvailable(), false);

    }

}