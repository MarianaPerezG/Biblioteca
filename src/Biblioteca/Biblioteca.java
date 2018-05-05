package Biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Book.Book;

public class Biblioteca {

    private String name;
    private static final String WELCOME_MESSAGE = "Welcome to";
    private static final String GOODBYE_MESSAGE = "Thank you for using Biblioteca. See you soon.";
    private static final String INVALID_OPTION_MESSAGE = "The option you have chosen is not a valid one, please try again";
    private static final String INVALID_MENU_MESSAGE = "The option you have chosen is not in the menu, please try again";
    private static final String SELECT_MESSSAGE = "Select the book you want to checkout";

    public ArrayList<Book> bookList;

    public Biblioteca(String name){
        this.name = name;
        this.bookList = new ArrayList<Book>();

    }

    public void giveWelcome(){
        System.out.println(WELCOME_MESSAGE + " " + name);
    }

    private void giveGoodBye(){

        System.out.println(GOODBYE_MESSAGE );
        System.exit(0);

    }

    public void init(){
        printMenu();
        manageInput();
    }

    private void printMenu(){

        System.out.println("Please, choose a valid option:");
        System.out.println("(1) Book List");
        System.out.println("(2) Quit");
        System.out.println("(3) Checkout");
        System.out.println("(4) Back to Menu");

    }

    private void manageInput(){

        while(true){
            int input = getInput();
            chooseOption(input);
        }

    }

    private int getInput(){

        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(INVALID_OPTION_MESSAGE);
            return getInput();
        }

    }


    private void chooseOption(int option){

        if(option == 1){
            printBookList();
            printMenu();
        }
        else if(option == 2){
            giveGoodBye();
        }
        else if(option == 3){
            getOptionToCheckOut();
        }
        else if(option == 4){
            printMenu();
        }
        else{
            System.out.println(INVALID_MENU_MESSAGE);
        }

    }

    private void printBookList(){

        for (int i=0; i<this.bookList.size(); i++){

            Book book = this.bookList.get(i);
            if(book.isAvailable()){
                System.out.println(book.getName() + ' ' + book.getAuthor() + ' ' + book.getYearPublished());
            }

        }
    }

    private void getOptionToCheckOut(){

        System.out.println(SELECT_MESSSAGE);

    }

    public boolean checkOut(Book book){

        return true;
    }

}
