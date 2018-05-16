package com.twu.Actions;

import com.twu.Helpers.InputReader;
import com.twu.Helpers.Messages;
import com.twu.Helpers.Printer;
import com.twu.biblioteca.BibliotecaManager;


public class MovieCheckOut extends Command {

    public MovieCheckOut(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager, Boolean forAdmin) {
        super(name, id, printer, inputReader, bibliotecaManager, forAdmin);
    }

    public void executeAction(){
        bibliotecaManager.manageMovieCheckOut(getItemReference());
    }

    public String getItemReference() {
        printer.printWithColor(Messages.SELECT_MESSAGE, "BLUE");
        return inputReader.getInput();
    }
}
