package com.twu.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private  Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Test", "Test Author", 2018, 3.8f);
    }

    @Test
    public void shouldCheckIfMovieIsAvailable(){
        assertEquals(movie.isAvailable(), true);
    }

    @Test
    public void shouldMarkTakenAMovie(){
        assertEquals(movie.isAvailable(), true);
        movie.setCheckedOut();
        assertEquals(movie.isAvailable(), false);

    }


}