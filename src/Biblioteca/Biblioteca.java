package Biblioteca;

import Helpers.InputReader;
import Helpers.Messages;
import Helpers.Printer;
import Helpers.Menu;
import Book.Book;


import java.util.ArrayList;
import java.util.InputMismatchException;


public class Biblioteca {

    private String name;
    private Printer printer;
    private Menu menu;
    private InputReader inputReader;
    public ArrayList<Book> bookList;

    public Biblioteca(String name, InputReader inputReader, Printer printer, Menu menu){
        this.name = name;
        this.bookList = new ArrayList<Book>();
        this.printer = printer;
        this.inputReader = inputReader;
        this.menu = menu;
    }

    public void giveWelcome(){
        printer.print(Messages.WELCOME_MESSAGE + " " + name);
    }

    private void giveGoodBye(){
        printer.print(Messages.GOODBYE_MESSAGE );
        System.exit(0);
    }

    public void init(){

        while(true){
            menu.printMenu();
            String input = inputReader.getInput();
            chooseOption(input);
        }

    }

    private void chooseOption(String option){

        if(option.equals("1")){
            printBookList(this.bookList);
        }
        else if(option.equals("2")){
            giveGoodBye();
        }
        else if(option.equals("3")){
            getOptionToCheckOut();
        }
        else{
            printer.print(Messages.INVALID_MENU_MESSAGE);
        }

    }

    private void getOptionToCheckOut(){

        printer.print(Messages.SELECT_MESSAGE);
        String selected = inputReader.getInput();
        manageResponse(selected);
    }

    private void manageResponse(String selected){

        ArrayList<Book> selectedBooks = getBooksInList(selected);

        if( selectedBooks.size() == 0){
            printer.print(Messages.EMPTY_BOOK_LIST);
            getOptionToCheckOut();
        }
        else if (selectedBooks.size() == 1){
            checkOut(selectedBooks.get(0));
        }
        else{
            printer.print(Messages.SELECT_OPTION);
            printBookList(selectedBooks);
            getOptionToCheckOut();

        }

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

    public void checkOut(Book book){

        book.markTaken();

    }

    private void printBookList(ArrayList books){

        for (int i=0; i<books.size(); i++){

            Book book = (Book) books.get(i);
            if(book.isAvailable()){
                System.out.println(book.getName() + ' ' + book.getAuthor() + ' ' + book.getYearPublished());
            }

        }
    }

}
