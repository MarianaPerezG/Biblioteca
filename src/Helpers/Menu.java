package Helpers;

public class Menu {

    private Printer printer;

    public Menu(){
        this.printer = new Printer();
    }

    public void printMenu(){
        printer.print("Please, choose a valid option:");
        printer.print("(1) Book List");
        printer.print("(2) Checkout");
        printer.print("(3) Return");
        printer.print("(4) Quit");
    }
}
