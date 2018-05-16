package com.twu.Actions;

import com.twu.Helpers.InputReader;
import com.twu.Helpers.Messages;
import com.twu.Helpers.Printer;
import com.twu.biblioteca.BibliotecaManager;


public class MovieCheckIn extends Command {

    public MovieCheckIn(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager, Boolean forAdmin) {
        super(name, id, printer, inputReader, bibliotecaManager, forAdmin);
    }

    public void executeAction(){
        bibliotecaManager.manageMovieCheckIn(getItemReference());;
    }

    public String getItemReference() {
        printer.printWithColor(Messages.SELECT_MESSAGE, "BLUE");
        return inputReader.getInput();
    }
}
