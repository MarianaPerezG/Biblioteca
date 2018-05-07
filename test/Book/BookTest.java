package Book;

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
    public void checkIfBookisAvaliable(){
        assertEquals(book.isAvailable(), true);
    }



}