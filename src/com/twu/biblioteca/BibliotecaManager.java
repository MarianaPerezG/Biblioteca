package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Models.*;
import com.twu.biblioteca.Biblioteca;

import java.util.ArrayList;

public class BibliotecaManager {

    private Biblioteca biblioteca;
    private Printer printer;
    private User loggedUser;

    public BibliotecaManager(Biblioteca biblioteca, Printer printer ){
        this.biblioteca = biblioteca;
        this.printer = printer;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    private boolean isReadyToCheck(ArrayList<? extends CheckableItem> items){

        if(items.size() == 1){
            return true;
        }else if(items.size() == 0){
            printer.printWithColor(Messages.EMPTY_LIST, "RED");

        }else{
            printer.printWithColor(Messages.SELECT_OPTION, "BLUE");
            printer.printList(items, true);
        }

        return false;

    }

    public boolean manageBookCheckOut(String option){

        ArrayList<Book> selectedBooks = biblioteca.getBooksMatchingInList(option , true);

        if (isReadyToCheck(selectedBooks) && selectedBooks.get(0).isAvailable()){
            checkOut(selectedBooks.get(0));
            return true;
        }

        return false;

    }

    public boolean manageBookCheckIn(String option){
        ArrayList<Book> selectedBooks = biblioteca.getBooksMatchingInList(option , false);

        if (isReadyToCheck(selectedBooks) && !selectedBooks.get(0).isAvailable() && userHasItem(selectedBooks.get(0))){
            checkIn(selectedBooks.get(0));
            return true;
        }
        return false;
    }

    public boolean manageMovieCheckOut(String option){
        ArrayList<Movie> selectedMovies = biblioteca.getMoviesMatchingInList(option , true);

        if (isReadyToCheck(selectedMovies) && selectedMovies.get(0).isAvailable()){
            checkOut(selectedMovies.get(0));
            return true;
        }

        return false;
    }

    public boolean manageMovieCheckIn(String option){
        ArrayList<Movie> selectedMovies = biblioteca.getMoviesMatchingInList(option , false);

        if (isReadyToCheck(selectedMovies) && !selectedMovies.get(0).isAvailable() && userHasItem(selectedMovies.get(0))){
            checkIn(selectedMovies.get(0));
            return true;
        }

        return false;
    }

    private boolean userHasItem(CheckableItem item) {

        for (Loan loan:biblioteca.getLoanList()){
            if (loan.isLoan(this.loggedUser, item)){
                return true;
            }
        }

        return false;
    }

    private boolean checkOut(CheckableItem item) {

        if (item.isAvailable()) {
            item.setCheckedOut();
            createALoan(item);
            printer.printWithColor(Messages.CHECKOUT_INFO + " " + item.getInfo(), "GREEN");
            printer.printWithColor(Messages.CHECKOUT_SUCCESSFUL, "GREEN");
            return true ;

        } else {
            printer.printWithColor(Messages.CHECKOUT_UNSUCCESSFUL, "RED");
            return false;
        }
    }

    private void createALoan(CheckableItem item) {
        biblioteca.getLoanList().add(new Loan(this.loggedUser, item));
    }

    private boolean checkIn(CheckableItem item) {

        if (!item.isAvailable()) {
            item.setCheckedIn();
            removeLoan(item);
            printer.printWithColor(Messages.RETURN_INFO + " " + item.getInfo(), "GREEN");
            printer.printWithColor(Messages.RETURN_SUCCESSFUL, "GREEN");
            return true;

        } else {
            printer.printWithColor(Messages.RETURN_UNSUCCESSFUL, "RED");
            return false;
        }

    }

    private void removeLoan(CheckableItem item) {

        Loan getLoan = null;

        for (Loan loan:biblioteca.getLoanList()){
            if (loan.isLoan(this.loggedUser, item)){
                getLoan = loan;
                break;
            }
        }

        try{
            biblioteca.getLoanList().remove(getLoan);
        }catch(IndexOutOfBoundsException ex){
            printer.print(Messages.INCORRECT_ITEM);
        }

    }

    public void showAllBooksList(){
        printer.printList(biblioteca.getBookList(), true);
    }

    public void showAllMoviesList(){
        printer.printList(biblioteca.getMovieList(), true);
    }

    public void giveWelcome(){
        printer.print(biblioteca.welcomeMessage());
    }

    public void giveGoodBye(){
        printer.print(biblioteca.goodByMessage());
        System.exit(0);

    }

    public void assignUser(User userToLogin) {
        this.loggedUser = userToLogin;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public boolean hasUser(){
        if(loggedUser instanceof User){
            return true;
        }
        return false;
    }

    public void getLoansInformation() {

        for (Loan loan : biblioteca.getLoanList()) {

            if (loggedUser.isAdmin()) {
                printer.print(loan.getInfoAdmin());
            } else {
                if (loan.getUser() == loggedUser) {
                    printer.print(loan.getInfo());
                }
            }
        }
    }

}
