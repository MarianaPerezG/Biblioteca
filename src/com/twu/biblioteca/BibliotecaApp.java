package com.twu.biblioteca;

import com.twu.Helpers.*;
import com.twu.Models.*;


public class BibliotecaApp {

    private static Biblioteca biblioteca;
    private static BibliotecaManager bibliotecaManager;
    private static InputReader inputReader;
    private static Menu menu;
    private static Printer printer;

    public static void main(String[] args) {

        printer = new Printer();
        inputReader = new InputReader(printer);

        biblioteca = new Biblioteca("The Bangalore Public Library");
        bibliotecaManager = new BibliotecaManager(biblioteca, printer);
        menu = new Menu(bibliotecaManager, inputReader);

        addDB(biblioteca);

        bibliotecaManager.giveWelcome();
        login();

    }

    public static void login(){

        boolean accessGranted = false;

        while(!accessGranted){
            printer.print(Messages.GET_USER_LIBRARYNUMBER);
            String libraryNumber = inputReader.getInput();
            printer.print(Messages.GET_USER_PASSWORD);
            String password = inputReader.getInput();

            accessGranted = bibliotecaManager.giveAccess(libraryNumber, password);

            if(accessGranted){
                init();
            }else{
                printer.printWithColor(Messages.INCORRECT_LOGIN, "RED");
            }

        }

    }

    public static void init(){

        while (true) {
            menu.printMenu();
            String input = inputReader.getInput();
            try{
                menu.comandoLines.get(input).executeAction();
            }
            catch (NullPointerException e){
                printer.print(Messages.INVALID_MENU_MESSAGE);
            }
        }
    }

    public static void addDB(Biblioteca biblioteca){

        biblioteca.getBookList().add(new Book("Living la vida loca", "Ricky Martin", 1989));
        biblioteca.getBookList().add(new Book("What life is all about", "Spongebob squarepants", 2010));
        biblioteca.getBookList().add(new Book("Something Random", "Kylie Jenner", 2018));
        biblioteca.getBookList().add(new Book("Liv Tyler Bio ", "Liv Tyler", 1980));

        biblioteca.getMovieList().add(new Movie("50 first Dates", "Peter Segal", 2004, 5.0f));
        biblioteca.getMovieList().add(new Movie("Random", "Mariana Perez", 2018, 2.0f));

        biblioteca.getUserList().add(new User("Mariana", "Perez","123-123","password", "mperez@prueba.com", "555-55-55", false ));
        biblioteca.getUserList().add(new User("Librarian", "User","111-111","admin", "librarian@prueba.com", "666-55-55", true ));


    }

}
