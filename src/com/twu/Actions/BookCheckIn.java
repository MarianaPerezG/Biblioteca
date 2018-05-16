package com.twu.Actions;

import com.twu.Helpers.InputReader;
import com.twu.Helpers.Messages;
import com.twu.Helpers.Printer;
import com.twu.biblioteca.BibliotecaManager;


public class BookCheckIn extends Command {

    public BookCheckIn(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager) {
        super(name, id, printer, inputReader, bibliotecaManager);
    }

    public void executeAction(){
        bibliotecaManager.manageBookCheckIn(getItemReference());
    }

    public String getItemReference() {
        printer.printWithColor(Messages.SELECT_MESSAGE, "BLUE");
        return inputReader.getInput();
    }
}
