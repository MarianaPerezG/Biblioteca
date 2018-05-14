package com.twu.Item;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    private  Book book;

    @Before
    public void setUp() {
        book = new Book("Test", "Test Author", 2018);
    }

    @Test
    public void shouldCheckIfBookIsAvailable(){
        assertEquals(book.isAvailable(), true);
    }

    @Test
    public void shouldMarkTakenABook(){
        assertEquals(book.isAvailable(), true);
        book.checkOut();
        assertEquals(book.isAvailable(), false);

    }


}