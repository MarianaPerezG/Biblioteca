package Helpers;

public class Menu {

    private Printer printer;

    public Menu(){
        this.printer = new Printer();
    }

    public void printMenu(){
        printer.printWithColor("Please, choose a valid option:", "BLUE");
        printer.printWithColor("(1) Book List", "BLUE");
        printer.printWithColor("(2) Checkout", "BLUE");
        printer.printWithColor("(3) Return", "BLUE");
        printer.printWithColor("(4) Quit", "BLUE");
    }
}
