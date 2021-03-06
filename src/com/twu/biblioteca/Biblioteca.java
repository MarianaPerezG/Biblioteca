package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Models.*;

import java.util.ArrayList;

public class Biblioteca {

    private String name;
    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<User> userList;
    private ArrayList<Loan> loanList;

    public Biblioteca(String name) {
        this.name = name;
        this.bookList = new ArrayList<Book>();
        this.movieList = new ArrayList<Movie>();
        this.userList = new ArrayList<User>();
        this.loanList = new ArrayList<Loan>();
    }

    public String welcomeMessage() {

        return Messages.WELCOME_MESSAGE + " " + name;

    }

    public String goodByMessage() {

        return Messages.GOODBYE_MESSAGE;
    }

    public ArrayList<Book> getBooksMatchingInList(String selected, Boolean available) {

        ArrayList<Book> booksFound = new ArrayList<Book>();

        for (Book book:bookList) {

            if (book.isAvailable() == available) {
                if (book.getName().toLowerCase().contains(selected.toLowerCase()) || book.getAuthor().toLowerCase().contains(selected.toLowerCase())) {
                    booksFound.add(book);
                }
            }

        }

        return booksFound;
    }

    public ArrayList<Movie> getMoviesMatchingInList(String selected, Boolean available) {

        ArrayList<Movie> moviesFound = new ArrayList<Movie>();

        for (Movie movie:movieList) {

            if (movie.isAvailable() == available) {
                if (movie.getName().toLowerCase().contains(selected.toLowerCase())) {
                    moviesFound.add(movie);
                }
            }

        }

        return moviesFound;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public ArrayList<Movie> getMovieList(){
        return movieList;
    }

    public ArrayList<User> getUserList(){ return userList;}

    public ArrayList<Loan> getLoanList() {return loanList;
    }
}
