package com.twu.Actions;

import com.twu.Helpers.Messages;
import com.twu.biblioteca.BibliotecaManager;
import com.twu.Helpers.*;


public class BookCheckOut extends Command {

    public BookCheckOut(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager) {
        super(name, id, printer, inputReader, bibliotecaManager);
    }

    public void executeAction(){
        bibliotecaManager.manageBookCheckOut(getItemReference());
    }

    public String getItemReference() {
        printer.printWithColor(Messages.SELECT_MESSAGE, "BLUE");
        return inputReader.getInput();
    }
}
