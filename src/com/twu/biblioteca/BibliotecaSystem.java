package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Item.*;
import java.util.ArrayList;

public class BibliotecaSystem {

    private Biblioteca biblioteca;
    private Printer printer;

    public BibliotecaSystem(Biblioteca biblioteca, Printer printer ){
        this.biblioteca = biblioteca;
        this.printer = printer;
    }

    public boolean manageResponseToCheckoutBook(String selected) {

        ArrayList<Book> selectedBooks = biblioteca.getBooksMatchingInList(selected, true);

        if (selectedBooks.size() == 0) {
            printer.print(Messages.EMPTY_BOOK_LIST);
            return false;
        } else if (selectedBooks.size() == 1) {
            return checkOut(selectedBooks.get(0));
        } else {
            printer.print(Messages.SELECT_OPTION);
            printList(selectedBooks, true);
            return false;
        }

    }

    public boolean manageResponseToCheckInBook(String selected) {

        ArrayList<Book> selectedBooks = biblioteca.getBooksMatchingInList(selected, false);

        if (selectedBooks.size() == 0) {
            printer.print(Messages.EMPTY_BOOK_LIST);
            return false;
        } else if (selectedBooks.size() == 1) {
            return checkIn(selectedBooks.get(0));
        } else {
            printer.print(Messages.SELECT_OPTION);
            printList(selectedBooks, false);
            return false;
        }

    }

    public boolean manageResponseToCheckoutMovie(String selected) {

        ArrayList<Movie> selectedMovies = biblioteca.getMoviesMatchingInList(selected, true);

        if (selectedMovies.size() == 0) {
            printer.print(Messages.EMPTY_BOOK_LIST);
            return false;
        } else if (selectedMovies.size() == 1) {
            return checkOut(selectedMovies.get(0));
        } else {
            printer.print(Messages.SELECT_OPTION);
            printList(selectedMovies, true);
            return false;

        }

    }

    public boolean manageResponseToCheckInMovie(String selected) {

        ArrayList<Movie> selectedMovies = biblioteca.getMoviesMatchingInList(selected, false);

        if (selectedMovies.size() == 0) {
            printer.print(Messages.EMPTY_BOOK_LIST);
            return false;
        } else if (selectedMovies.size() == 1) {
            return checkIn(selectedMovies.get(0));
        } else {
            printer.print(Messages.SELECT_OPTION);
            printList(selectedMovies, false);
            return false;

        }

    }

    public boolean checkOut(checkableItem item) {

        if (item.isAvailable()) {
            item.checkOut();
            printer.printWithColor(Messages.CHECKOUT_INFO + " " + item.getInfo(), "GREEN");
            printer.printWithColor(Messages.CHECKOUT_SUCCESSFUL, "GREEN");
            return true;

        } else {
            printer.printWithColor(Messages.CHECKOUT_UNSUCCESSFUL, "RED");
            return false;
        }

    }

    public boolean checkIn(checkableItem item) {

        if (!item.isAvailable()) {
            item.checkIn();
            printer.printWithColor(Messages.RETURN_INFO + " " + item.getInfo(), "GREEN");
            printer.printWithColor(Messages.RETURN_SUCCESSFUL, "GREEN");
            return true ;

        } else {
            printer.printWithColor(Messages.RETURN_UNSUCCESSFUL, "RED");
            return false;
        }

    }

    public void printList(ArrayList<? extends checkableItem> items, Boolean available) {

        for (checkableItem item : items) {

            if (item.isAvailable() == available) {
                printer.print(item.getInfo());
            }

        }
    }


}
