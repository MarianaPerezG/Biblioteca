package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Models.*;
import java.util.ArrayList;

public class BibliotecaSystem {

    private Biblioteca biblioteca;
    private Printer printer;

    public BibliotecaSystem(Biblioteca biblioteca, Printer printer ){
        this.biblioteca = biblioteca;
        this.printer = printer;
    }

    private boolean isReadyToCheck(ArrayList<? extends CheckableItem> items){

        if(items.size() == 1){
            return true;
        }else if(items.size() == 0){
            printer.printWithColor(Messages.EMPTY_LIST, "RED");

        }else{
            printer.printWithColor(Messages.SELECT_OPTION, "BLUE");
            printList(items, true);
        }

        return false;

    }

    public boolean manageBookCheckOut(String option){

        ArrayList<Book> selectedBooks = biblioteca.getBooksMatchingInList(option , true);
        if (isReadyToCheck(selectedBooks) && selectedBooks.get(0).isAvailable()){
            checkOut(selectedBooks.get(0));
            return true;
        }
        printer.printWithColor(Messages.CHECKOUT_UNSUCCESSFUL, "RED");
        return false;

    }

    public boolean manageBookCheckIn(String option){
        ArrayList<Book> selectedBooks = biblioteca.getBooksMatchingInList(option , false);
        if (isReadyToCheck(selectedBooks) && !selectedBooks.get(0).isAvailable()){
            checkIn(selectedBooks.get(0));
            return true;
        }
        printer.printWithColor(Messages.RETURN_UNSUCCESSFUL, "RED");
        return false;
    }

    public boolean manageMovieCheckOut(String option){
        ArrayList<Movie> selectedMovies = biblioteca.getMoviesMatchingInList(option , true);
        if (isReadyToCheck(selectedMovies) && selectedMovies.get(0).isAvailable()){
            checkOut(selectedMovies.get(0));
            return true;
        }
        printer.printWithColor(Messages.CHECKOUT_UNSUCCESSFUL, "RED");
        return false;
    }

    public boolean manageMovieCheckIn(String option){
        ArrayList<Movie> selectedMovies = biblioteca.getMoviesMatchingInList(option , false);
        if (isReadyToCheck(selectedMovies) && !selectedMovies.get(0).isAvailable()){
            checkIn(selectedMovies.get(0));
            return true;
        }
        printer.printWithColor(Messages.RETURN_UNSUCCESSFUL, "RED");
        return false;
    }

    private boolean checkOut(CheckableItem item) {

        if (item.isAvailable()) {
            item.setCheckedOut();
            printer.printWithColor(Messages.CHECKOUT_INFO + " " + item.getInfo(), "GREEN");
            printer.printWithColor(Messages.CHECKOUT_SUCCESSFUL, "GREEN");
            return true ;

        } else {
            return false;
        }
    }

    private boolean checkIn(CheckableItem item) {

        if (!item.isAvailable()) {
            item.setCheckedIn();
            printer.printWithColor(Messages.RETURN_INFO + " " + item.getInfo(), "GREEN");
            printer.printWithColor(Messages.RETURN_SUCCESSFUL, "GREEN");
            return true;

        } else {
            return false;
        }

    }

    public void printList(ArrayList<? extends CheckableItem> items, Boolean available) {

        System.out.println("HERE");
        for (CheckableItem item : items) {

            if (item.isAvailable() == available) {
                printer.print(item.getInfo());
            }

        }
    }


}
