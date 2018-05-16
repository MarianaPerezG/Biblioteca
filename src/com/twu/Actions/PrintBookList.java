package com.twu.Actions;

import com.twu.biblioteca.*;
import com.twu.Helpers.*;

public class PrintBookList extends Command {

    public PrintBookList(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager,Boolean forAdmin) {
        super(name, id, printer, inputReader, bibliotecaManager, forAdmin);
    }

    public void executeAction(){
        bibliotecaManager.showAllBooksList();
    }
}
