package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Item.*;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

public class BibliotecaTest {

    public Biblioteca biblioteca;
    public Book book;
    public Movie movie;

    @Before
    public void setUp() {

        biblioteca = new Biblioteca("Test");
        book = new Book("Test", "Test Author", 2018);
        movie = new Movie("Test Movie", "Test director", 2018, 5.0f);
        biblioteca.getBookList().add(book);
        biblioteca.getMovieList().add(movie);
    }

    @Test
    public void shouldReturnWelcomeMessageWithName(){

        assertEquals(biblioteca.welcomeMessage(), "Welcome to Test");
    }

    @Test
    public void shouldReturnGoodbyeMessage(){
        assertEquals(biblioteca.giveGoodBye(), Messages.GOODBYE_MESSAGE);
    }

    @Test
    public void shouldGetBooksInListThatAreAvailable(){

        ArrayList<Book> correctArray = new ArrayList<Book>();
        correctArray.add(book);

        assertEquals(biblioteca.getBooksMatchingInList("Te", true), correctArray);
    }

    @Test
    public void shouldGetMoviesInListThatAreAvailable(){

        ArrayList<Movie> correctArray = new ArrayList<Movie>();
        correctArray.add(movie);

        assertEquals(biblioteca.getMoviesMatchingInList("Te", true), correctArray);
    }

    @Test
    public void shouldReturnEmptyArrayListIfNotMatchBookFoundAvailable(){
        ArrayList<Book> correctArray = new ArrayList<Book>();
        assertEquals(biblioteca.getBooksMatchingInList("Random String", true), correctArray);
    }

    @Test
    public void shouldReturnEmptyArrayListIfNotMatchMovieFoundAvailable(){
        ArrayList<Movie> correctArray = new ArrayList<Movie>();
        assertEquals(biblioteca.getMoviesMatchingInList("Random String", true), correctArray);
    }

    @Test
    public void shouldGetBooksInListThatAreNotAvailable(){

        ArrayList<Book> correctArray = new ArrayList<Book>();
        book.checkOut();
        correctArray.add(book);

        assertEquals(biblioteca.getBooksMatchingInList("Te", false), correctArray);
    }

    @Test
    public void shouldGetMoviesInListThatAreNotAvailable(){

        ArrayList<Movie> correctArray = new ArrayList<Movie>();
        movie.checkOut();
        correctArray.add(movie);

        assertEquals(biblioteca.getMoviesMatchingInList("Te", false), correctArray);
    }

}