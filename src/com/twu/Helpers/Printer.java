package com.twu.Helpers;

public class Printer {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public void printWithColor(String toPrint, String color){

        if (color == "GREEN"){
            System.out.println(ANSI_GREEN + toPrint + ANSI_RESET);

        }
        else if (color == "RED" ){
            System.out.println(ANSI_RED + toPrint + ANSI_RESET);
        }
        else if(color == "BLUE"){
            System.out.println(ANSI_CYAN + toPrint + ANSI_RESET);
        }
    }

    public void print(String toPrint){
        System.out.println(toPrint);
    }


}
