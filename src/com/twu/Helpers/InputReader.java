package com.twu.Helpers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

    private Scanner scanner;
    private Printer printer;

    public InputReader(Printer printer){
        this.scanner = new Scanner(System.in);
        this.printer = printer;
    }

    public String getInput(){

        try {
            return scanner.nextLine();
        } catch (InputMismatchException ex) {
            printer.print(Messages.INVALID_OPTION_MESSAGE);
            return getInput();
        }

    }

}
