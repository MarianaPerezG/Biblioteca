package com.twu.Models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    private  Book book;

    @Test
    public void shouldCheckIfBookIsAvailable(){
//        given
        book = new Book("Test", "Test Author", 2018);
//        when
        boolean returned = book.isAvailable();
//        then
        assertEquals(returned , true);
    }

    @Test
    public void shouldMarkTakenABook(){
//        given
        book = new Book("Test", "Test Author", 2018);
//        when
        book.setCheckedOut();
        boolean returned = book.isAvailable();
//        then
        assertEquals(returned, false);

    }
    
}