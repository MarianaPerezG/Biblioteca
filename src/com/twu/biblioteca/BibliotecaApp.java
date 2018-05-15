package com.twu.biblioteca;

import com.twu.Helpers.*;

import com.twu.Models.Book;
import com.twu.Models.Movie;

public class BibliotecaApp {

    private static Biblioteca biblioteca;
    private static BibliotecaSystem bibliotecaSys;
    private static InputReader inputReader;
    private static Menu menu;
    private static Printer printer;

    public static void main(String[] args) {

        printer = new Printer();
        menu = new Menu();
        inputReader = new InputReader(printer);

        biblioteca = new Biblioteca("The Bangalore Public Library");
        bibliotecaSys = new BibliotecaSystem(biblioteca, printer);
        addDB(biblioteca);
        init();

    }

    public static void init(){

        printer.print(biblioteca.welcomeMessage());

        while (true) {
            menu.printMenu();
            String input = inputReader.getInput();
            manageOption(input);
        }
    }

    public static void manageOption(String input){

        try{
            int option = Integer.parseInt(input);
            switch(option){
                case 1:
                    bibliotecaSys.printList(biblioteca.getBookList(), true);
                    break;
                case 2:
                    bibliotecaSys.manageBookCheckOut(getItemReference());
                    break;
                case 3:
                    bibliotecaSys.manageBookCheckIn(getItemReference());
                    break;
                case 4:
                    bibliotecaSys.printList(biblioteca.getMovieList(), true);
                    break;
                case 5:
                    bibliotecaSys.manageMovieCheckOut(getItemReference());
                    break;
                case 6:
                    bibliotecaSys.manageMovieCheckIn(getItemReference());
                    break;
                case 7:
                    printer.print(biblioteca.giveGoodBye());
                    System.exit(0);
            }

        }catch (NumberFormatException  e){
            printer.print(Messages.INVALID_MENU_MESSAGE);
        }

    }

    public static String getItemReference() {
        printer.printWithColor(Messages.SELECT_MESSAGE, "BLUE");
        return inputReader.getInput();
    }

    public static void addDB(Biblioteca biblioteca){

        biblioteca.getBookList().add(new Book("Living la vida loca", "Ricky Martin", 1989));
        biblioteca.getBookList().add(new Book("What life is all about", "Spongebob squarepants", 2010));
        biblioteca.getBookList().add(new Book("Something Random", "Kylie Jenner", 2018));
        biblioteca.getBookList().add(new Book("Liv Tyler Bio ", "Liv Tyler", 1980));

        biblioteca.movieList.add(new Movie("50 first Dates", "Peter Segal", 2004, 5.0f));
        biblioteca.movieList.add(new Movie("Random", "Mariana Perez", 2018, 2.0f));

    }


}
