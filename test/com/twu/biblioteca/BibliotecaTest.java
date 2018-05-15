package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Models.*;

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
//        given
        String correctMessage = "Welcome to Test";
//        when
        String returnedMessage = biblioteca.welcomeMessage();
//        then
        assertEquals(returnedMessage,correctMessage);
    }

    @Test
    public void shouldReturnGoodbyeMessage(){
//        given
        String correctMessage = Messages.GOODBYE_MESSAGE;
//        when
        String returnedMessage = biblioteca.giveGoodBye();
//        then
        assertEquals(returnedMessage,correctMessage );
    }

    @Test
    public void shouldGetBooksInListThatAreAvailable(){
//        given
        ArrayList<Book> correctArray = new ArrayList<Book>();
//        when
        correctArray.add(book);
        ArrayList<Book> returnedArray = biblioteca.getBooksMatchingInList("Te", true);
//        then
        assertEquals(returnedArray, correctArray);
    }

    @Test
    public void shouldGetMoviesInListThatAreAvailable(){
//        given
        ArrayList<Movie> correctArray = new ArrayList<Movie>();
//        when
        correctArray.add(movie);
        ArrayList<Movie> returnedArray = biblioteca.getMoviesMatchingInList("Te", true);
//        then
        assertEquals(returnedArray, correctArray);
    }

    @Test
    public void shouldReturnEmptyArrayListIfNotMatchBookFoundAvailable(){
//        given
        ArrayList<Book> correctArray = new ArrayList<Book>();
//        when
        ArrayList<Book> returnedArray = biblioteca.getBooksMatchingInList("Random String", true);
//        then
        assertEquals(returnedArray, correctArray);
    }

    @Test
    public void shouldReturnEmptyArrayListIfNotMatchMovieFoundAvailable(){
//        given
        ArrayList<Movie> correctArray = new ArrayList<Movie>();
//        when
        ArrayList<Movie> returnedArray = biblioteca.getMoviesMatchingInList("Random String", true);
//        then
        assertEquals(returnedArray, correctArray);
    }

    @Test
    public void shouldGetBooksInListThatAreNotAvailable(){
//        given
        ArrayList<Book> correctArray = new ArrayList<Book>();
//        when
        book.setCheckedOut();
        correctArray.add(book);
        ArrayList<Book> returnedArray = biblioteca.getBooksMatchingInList("Te", false);
//        then
        assertEquals(returnedArray, correctArray);
    }

    @Test
    public void shouldGetMoviesInListThatAreNotAvailable(){
//        given
        ArrayList<Movie> correctArray = new ArrayList<Movie>();
//        when
        movie.setCheckedOut();
        correctArray.add(movie);
        ArrayList<Movie> returnedArray = biblioteca.getMoviesMatchingInList("Te", false);
//        then
        assertEquals(returnedArray, correctArray);
    }

}