package Biblioteca;

public class Biblioteca {

    private String name;
    private static final String WELCOME_MESSAGE = "Welcome to";

    public Biblioteca(String name){

        this.name = name;

    }

    public void giveWelcome(){

        System.out.println(WELCOME_MESSAGE + " " + name);

    }


}
