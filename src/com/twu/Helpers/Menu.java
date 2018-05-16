package com.twu.Helpers;

import java.util.HashMap;

import com.twu.Actions.*;

import com.twu.biblioteca.BibliotecaManager;

public class Menu {

    private Printer printer;
    private InputReader inputReader;
    public HashMap<String, Command> comandoLines;
    private BibliotecaManager bibliotecaMan;

    public Menu(BibliotecaManager bibliotecaManager, InputReader inputReader){
        this.printer = new Printer();
        this.bibliotecaMan = bibliotecaManager;
        this.inputReader = inputReader;
        this.comandoLines = new HashMap<String, Command>();
        setUp();
    }

    private void setUp() {

        PrintBookList printBook = new PrintBookList("Book List", 1, printer,inputReader, bibliotecaMan);
        BookCheckOut bookCheckOut = new BookCheckOut("Checkout Book", 2, printer,inputReader, bibliotecaMan);
        BookCheckIn bookCheckIn = new BookCheckIn("Return Book", 3, printer,inputReader, bibliotecaMan);
        PrintMovieList printMovieList = new PrintMovieList("Movie List", 4, printer,inputReader, bibliotecaMan);
        MovieCheckOut movieCheckOut = new MovieCheckOut("Checkout Movie", 5, printer,inputReader, bibliotecaMan);
        MovieCheckIn movieCheckIn = new MovieCheckIn("Return Movie", 6, printer,inputReader, bibliotecaMan);
        Exit exit = new Exit("Exit", 7, printer,inputReader, bibliotecaMan);

        comandoLines.put(printBook.getId().toString(), printBook);
        comandoLines.put(bookCheckOut.getId().toString(), bookCheckOut);
        comandoLines.put(bookCheckIn.getId().toString(), bookCheckIn);
        comandoLines.put(printMovieList.getId().toString(), printMovieList);
        comandoLines.put(movieCheckOut.getId().toString(), movieCheckOut);
        comandoLines.put(movieCheckIn.getId().toString(), movieCheckIn);
        comandoLines.put(exit.getId().toString(), exit);

    }

    public void printMenu(){

        printer.printWithColor( Messages.HEAD_MENU , "BLUE");

        for(Command command:comandoLines.values()){

            String title = command.getId() + " " + command.getName();
            printer.printWithColor( title , "BLUE");

        }

    }

}
