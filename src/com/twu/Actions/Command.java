package com.twu.Actions;

import com.twu.Helpers.InputReader;
import com.twu.Helpers.Printer;
import com.twu.biblioteca.BibliotecaManager;

public abstract class Command {

    public String name;
    public Integer id;
    public Printer printer;
    public InputReader inputReader;
    public BibliotecaManager bibliotecaManager;

    public Command(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager) {
        this.name = name;
        this.id = id;
        this.printer = printer;
        this.inputReader = inputReader;
        this.bibliotecaManager = bibliotecaManager;
    }

    public void executeAction(){}

    public String getName(){
        return name;
    }
    public Integer getId(){
        return id;
    }

}
