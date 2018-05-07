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

    }

    private void manageInput(){

        while(true){
            String input = getInput();
            chooseOption(input);
        }

    }

    private String getInput(){

        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextLine();
        } catch (InputMismatchException ex) {
            System.out.println(INVALID_OPTION_MESSAGE);
            return getInput();
        }

    }

    private void chooseOption(String option){

        if(option.equals("1")){
            printBookList(this.bookList);
            printMenu();
        }
        else if(option.equals("2")){
            giveGoodBye();
        }
        else if(option.equals("3")){
            getOptionToCheckOut();
        }
        else{
            System.out.println(INVALID_MENU_MESSAGE);
        }

    }

    private void printBookList(ArrayList books){

        for (int i=0; i<books.size(); i++){

            Book book = (Book) books.get(i);
            if(book.isAvailable()){
                System.out.println(book.getName() + ' ' + book.getAuthor() + ' ' + book.getYearPublished());
            }

        }
    }

    private void getOptionToCheckOut(){

        System.out.println(SELECT_MESSSAGE);
        String selected = getInput();
        checkOptionValidity(selected);

    }

    public ArrayList<Book> getBooksInList(String selected){

        ArrayList<Book> booksFound = new ArrayList<Book>();

        for (Book book:bookList){

            if (book.getName().toLowerCase().contains(selected.toLowerCase()) || book.getAuthor().toLowerCase().contains(selected.toLowerCase())){
                booksFound.add(book);
            }
        }

        return booksFound;
    }

    private void checkOptionValidity(String selected){

        ArrayList<Book> selectedBooks = getBooksInList(selected);

        if (selectedBooks.size() > 0){

            if(selectedBooks.size() == 1){

                checkOut(selectedBooks.get(0));

            }else{
                System.out.println("Please select between the options available:");
                printBookList(selectedBooks);
                getOptionToCheckOut();

            }


        }else{

            System.out.println("There is no book with that description. Try again");
            getOptionToCheckOut();

        }


    }

    public void checkOut(Book book){

        book.markTaken();
        printMenu();

    }

}
