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
    public boolean forAdmin = false;

    public Command(String name, Integer id, Printer printer, InputReader inputReader, BibliotecaManager bibliotecaManager, Boolean forAdmin) {
        this.name = name;
        this.id = id;
        this.printer = printer;
        this.inputReader = inputReader;
        this.bibliotecaManager = bibliotecaManager;
        this.forAdmin = forAdmin;
    }

    public void executeAction(){}

    public String getName(){
        return name;
    }
    public Integer getId(){
        return id;
    }

}
