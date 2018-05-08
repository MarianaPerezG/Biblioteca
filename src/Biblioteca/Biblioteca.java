package Biblioteca;

import Helpers.InputReader;
import Helpers.Messages;
import Helpers.Printer;
import Helpers.Menu;
import Item.Book;


import java.util.ArrayList;

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
            printBookList(this.bookList, true);
        }
        else if(option.equals("2")){

           String reference =  getItemReference();
            manageResponseToCheckoutBook(reference);
        }
        else if(option.equals("3")){

            String reference =  getItemReference();
            manageResponseReturnBook(reference);
        }
        else if(option.equals("4")){
            giveGoodBye();
        }
        else{
            printer.print(Messages.INVALID_MENU_MESSAGE);
        }

    }

    private String getItemReference(){

        printer.print(Messages.SELECT_MESSAGE);
        return inputReader.getInput();

    }

    private void manageResponseToCheckoutBook(String selected){

        ArrayList<Book> selectedBooks = getBooksInList(selected, true);

        if( selectedBooks.size() == 0){
            printer.print(Messages.EMPTY_BOOK_LIST);
            manageResponseToCheckoutBook(getItemReference());
        }
        else if (selectedBooks.size() == 1){
            checkOut(selectedBooks.get(0));
        }
        else{
            printer.print(Messages.SELECT_OPTION);
            printBookList(selectedBooks, true);
            manageResponseToCheckoutBook(getItemReference());

        }

    }

    public void manageResponseReturnBook(String selected){

        ArrayList<Book> selectedBooks = getBooksInList(selected, false);

        if( selectedBooks.size() == 0){
            printer.print(Messages.EMPTY_BOOK_LIST);
            manageResponseReturnBook(getItemReference());
        }
        else if (selectedBooks.size() == 1){
            returnBook(selectedBooks.get(0));
        }
        else{
            printer.print(Messages.SELECT_OPTION);
            printBookList(selectedBooks, false);
            manageResponseReturnBook(getItemReference());

        }


    }

    public ArrayList<Book> getBooksInList(String selected, Boolean available ){

        ArrayList<Book> booksFound = new ArrayList<Book>();

        for (Book book:bookList){

            if(book.isAvailable() == available){
                if (book.getName().toLowerCase().contains(selected.toLowerCase()) || book.getAuthor().toLowerCase().contains(selected.toLowerCase())){
                    booksFound.add(book);
                }
            }

        }

        return booksFound;
    }

    public boolean checkOut(Book book){

        if(book.isAvailable()){
            book.markTaken();
            printer.print(Messages.CHECKOUT_INFO + " " + book.getInfo());
            printer.print(Messages.CHECKOUT_SUCCESSFUL);

            return true;

        }else{
            printer.print(Messages.CHECKOUT_UNSUCCESSFUL);
            return false;
        }

    }

    public int printBookList(ArrayList books, Boolean available){

        int availableBooks = 0;

        for (int i=0; i<books.size(); i++){

            Book book = (Book) books.get(i);
            if(book.isAvailable() == available){
                availableBooks++;
               printer.print(book.getInfo());
            }

        }

        return availableBooks;
    }

    public boolean returnBook(Book book){

        if(!book.isAvailable()){
            book.markAvailable();
            printer.print(Messages.RETURN_INFO + " " + book.getInfo());
            printer.print(Messages.RETURN_SUCCESSFUL);
            return true;

        }else{
            printer.print(Messages.RETURN_UNSUCCESSFUL);
            return false;
        }

    }

}
