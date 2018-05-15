package com.twu.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private  Movie movie;

    @Test
    public void shouldCheckIfMovieIsAvailable(){
//        given
        movie = new Movie("Test", "Test Author", 2018, 3.8f);
//        when
        boolean returned = movie.isAvailable();
//        then
        assertEquals(returned, true);
    }

    @Test
    public void shouldMarkTakenAMovie(){
//        given
        movie = new Movie("Test", "Test Author", 2018, 3.8f);
//        when
        movie.setCheckedOut();
        boolean returned = movie.isAvailable();
//        then
        assertEquals(returned , false);

    }

}