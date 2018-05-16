package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Models.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaManagerTest {

    public Biblioteca biblioteca;
    public BibliotecaManager bibliotecaSys;
    public Book book;
    public Movie movie;
    public Printer printer;
    public User user;
    public InputReader inputreader;
    public String input;
    public OutputStream output;

    @Before
    public void setUp() {

        printer = new Printer();
        biblioteca = new Biblioteca("Test");
        bibliotecaSys = new BibliotecaManager(biblioteca, printer);

    }

    public void bibliotecaWithBook(){
        book = new Book("Test", "Test Author", 2018);
        biblioteca.getBookList().add(book);

    }

    public void bibliotecaWithMovie(){
        movie = new Movie("Test Movie", "Test director", 2018, 5.0f);
        biblioteca.getMovieList().add(movie);
    }

    public void bibliotecaWithUser(){
        user = new User("Mariana", "Perez","123-123","password", "mperez@prueba.com", "555-55-55", false );
        biblioteca.getUserList().add(user);
    }

    public OutputStream theOutput(){
        output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);
        return output;
    }

    @Test
    public void shouldCheckOutAnAvailableBook(){
//        given
        bibliotecaWithBook();
//        when
        String correctBookName = book.getName();
        boolean returned = bibliotecaSys.manageBookCheckOut(correctBookName);
//        then
        assertEquals(returned, true);
    }

    @Test
    public void shouldNotAllowCheckOutIfNotMatchingBook(){
//        given
        bibliotecaWithBook();
//        when
        String nameOfBook = "Random";
        boolean returned = bibliotecaSys.manageBookCheckOut(nameOfBook);
//        then
        assertEquals(returned, false);
    }

    @Test
    public void shouldNotCheckOutIfAnUnavailableBook(){
//        given
        bibliotecaWithBook();
//        when
        String nameOfBook = book.getName();
        book.setCheckedOut();
        boolean returned = bibliotecaSys.manageBookCheckOut(nameOfBook);
//        then
        assertEquals(returned, false);
    }

    @Test
    public void shouldReturnUnavailableItemMessageIfBookIsUnavailable(){
//        given
        bibliotecaWithBook();
//        when
        String nameOfBook = book.getName();
        book.setCheckedOut();
        OutputStream output = theOutput();
        bibliotecaSys.manageBookCheckOut(nameOfBook);
        String correctMessage = Messages.EMPTY_LIST;
//        then
        assertTrue(output.toString().contains(correctMessage));
    }

    @Test
    public void shouldReturnSelectOptionMessageWhenMultipleBookResultsAvailable(){
//        given
        bibliotecaWithBook();
        biblioteca.getBookList().add(new Book( "Test Book", "New Author", 2010));
//        when
        String nameOfBook = "Test";
        OutputStream output = theOutput();
        bibliotecaSys.manageBookCheckOut(nameOfBook);
        String correctMessage = Messages.SELECT_OPTION;
//        then
        assertTrue(output.toString().contains(correctMessage));

    }

    @Test
    public void shouldNotCheckInAnAvailableBook(){
//        given
        bibliotecaWithBook();
//        when
        String correctBookName = book.getName();
        boolean returned = bibliotecaSys.manageBookCheckIn(correctBookName);
//        then
        assertEquals(returned, false);
    }

    @Test
    public void shouldCheckInATakenBook(){
//        given
        bibliotecaWithBook();
//        when
        String correctBookName = book.getName();
        book.setCheckedOut();
        boolean returned = bibliotecaSys.manageBookCheckIn(correctBookName);
//        then
        assertEquals(returned, true);
    }

    @Test
    public void shouldAllowCheckOutIfAvailableMovie(){
//        given
        bibliotecaWithMovie();
//        when
        String correctMovieName = movie.getName();
        boolean returned = bibliotecaSys.manageMovieCheckOut(correctMovieName);
//        then
        assertEquals(returned, true);
    }

    @Test
    public void shouldNotAllowCheckOutIfNotMatchingMovie(){
//        given
        bibliotecaWithMovie();
//        when
        String nameOfMovie = "Random";
        boolean returned = bibliotecaSys.manageMovieCheckOut(nameOfMovie);
//        then
        assertEquals(returned, false);
    }

    @Test
    public void shouldNotCheckOutIfAnUnavailableMovie(){
//        given
        bibliotecaWithMovie();
//        when
        String nameOfMovie = movie.getName();
        movie.setCheckedOut();
        boolean returned = bibliotecaSys.manageMovieCheckOut(nameOfMovie);
//        then
        assertEquals(returned, false);
    }

    @Test
    public void shouldReturnUnavailableItemMessageIfMovieIsUnavailable(){
//        given
        bibliotecaWithMovie();
//        when
        String nameOfMovie = movie.getName();
        movie.setCheckedOut();
        OutputStream output = theOutput();
        bibliotecaSys.manageMovieCheckOut(nameOfMovie);
        String correctMessage = Messages.EMPTY_LIST;
//        then
        assertTrue(output.toString().contains(correctMessage));
    }

    @Test
    public void shouldReturnSelectOptionMessageWhenMultipleMovieResultsAvailable(){
//        given
        bibliotecaWithMovie();
        biblioteca.getMovieList().add(new Movie( "Test Movie 2", "New Director", 2010,  6.4f));
//        when
        String nameOfMovie = "Test";
        OutputStream output = theOutput();
        bibliotecaSys.manageMovieCheckOut(nameOfMovie);
        String correctMessage = Messages.SELECT_OPTION;
//        then
        assertTrue(output.toString().contains(correctMessage));

    }

    @Test
    public void shouldNotCheckInAnAvailableMovie(){
//        given
        bibliotecaWithMovie();
//        when
        String correctMovieName = movie.getName();
        boolean returned = bibliotecaSys.manageMovieCheckIn(correctMovieName);
//        then
        assertEquals(returned, false);
    }

    @Test
    public void shouldCheckInATakenMovie(){
//        given
        bibliotecaWithMovie();
//        when
        String correctMovieName = movie.getName();
        movie.setCheckedOut();
        boolean returned = bibliotecaSys.manageMovieCheckIn(correctMovieName);
//        then
        assertEquals(returned, true);
    }

    @Test
    public void shouldPrintOnlyTheAvailableBooksOnTheList(){
//        given
        bibliotecaWithBook();
        biblioteca.getBookList().add(new Book("Book for testing", "Mariana Perez", 1998));
//        when
        OutputStream output = theOutput();
        bibliotecaSys.printList(biblioteca.getBookList(), true);
        String correctString = "Book for testing by Mariana Perez. Year of Publish: 1998";
//        then
        assertTrue(output.toString().contains(correctString));

    }

    @Test
    public void shouldPrintEnjoyMessageWhenCorrectCheckOut(){
        //        given
        bibliotecaWithBook();
//        when
        String nameOfBook = book.getName();
        OutputStream output = theOutput();
        bibliotecaSys.manageBookCheckOut(nameOfBook);
        String correctMessage = Messages.CHECKOUT_SUCCESSFUL;
//        then
        assertTrue(output.toString().contains(correctMessage));

    }

    @Test
    public void shouldAllowLogInOfUserIfUserExistAndThePasswordIsCorrect(){
//        given
        bibliotecaWithUser();
//        when
        String libraryNumberCollected = "123-123";
        String passwordCollected = "password";
        boolean returned = bibliotecaSys.giveAccess(libraryNumberCollected, passwordCollected );
//        then
        assertTrue(returned);
    }

    @Test
    public void shouldReturnUserIfLibraryNumberExist(){
//        given
        bibliotecaWithUser();
//        when
        String libraryNumberCollected = "123-123";
        User returned = bibliotecaSys.getUserWithLibraryNumber(libraryNumberCollected);
//        then
        assertThat(returned, instanceOf(User.class));

    }

    @Test
    public void shouldReturnTrueIfPasswordIsCorrect(){
//        given
        bibliotecaWithUser();
//        when
        String password = "password";
        boolean returned = bibliotecaSys.passwordIsCorrectForUser(password, user);
//        then
        assertTrue(returned);

    }


}