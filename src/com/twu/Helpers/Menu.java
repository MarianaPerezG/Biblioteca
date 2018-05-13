package com.twu.Helpers;

public class Menu {

    private Printer printer;

    public Menu(){
        this.printer = new Printer();
    }

    public void printMenu(){
        printer.printWithColor("Please, choose a valid option:", "BLUE");
        printer.printWithColor("(1) Book List", "BLUE");
        printer.printWithColor("(2) Checkout Book", "BLUE");
        printer.printWithColor("(3) Return Book", "BLUE");
        printer.printWithColor("(4) Movie List", "BLUE");
        printer.printWithColor("(5) Checkout Movie", "BLUE");
        printer.printWithColor("(6) Return Movie", "BLUE");
        printer.printWithColor("(7) Quit", "BLUE");
    }
}
