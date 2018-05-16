package com.twu.Actions;

import com.twu.Helpers.InputReader;
import com.twu.Helpers.Messages;
import com.twu.Helpers.Printer;
import com.twu.biblioteca.BibliotecaManager;


public class UserInformation extends Command {

    public UserInformation(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager) {
        super(name, id, printer, inputReader, bibliotecaManager);
    }

    public void executeAction(){ printer.print(bibliotecaManager.getLoggedUser().getInfo());}

    public String getItemReference() {
        printer.printWithColor(Messages.SELECT_MESSAGE, "BLUE");
        return inputReader.getInput();
    }
}
