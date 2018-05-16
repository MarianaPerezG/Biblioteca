package com.twu.Actions;

import com.twu.Helpers.InputReader;
import com.twu.Helpers.Printer;
import com.twu.biblioteca.BibliotecaManager;

public class Exit extends Command {

    public Exit(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager,Boolean forAdmin) {
        super(name, id, printer, inputReader, bibliotecaManager, forAdmin);
    }

    public void executeAction(){
        bibliotecaManager.giveGoodBye();
    }
}
