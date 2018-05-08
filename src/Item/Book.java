package Item;

public class Book implements checkableObject {

    private String name;
    private String author;
    private int yearPublished;
    public boolean available = true;

    public Book(String name, String author, int yearPublished){

        setName(name);
        setAuthor(author);
        setYearPublished(yearPublished);

    }

    private void setName(String name){
        this.name = name;
    }

    private void setAuthor (String author){
        this.author = author;
    }

    private void setYearPublished(int yearPublished){
        this.yearPublished = yearPublished;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public String getInfo(){
        return String.format("%s by %s. Year of Publish: %03d", this.getName(), this.getAuthor(), this.getYearPublished());
    }

    public int getYearPublished(){
        return yearPublished;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markTaken(){
        available = false;
    }

    public void markAvailable(){
        available = true;
    }

}
