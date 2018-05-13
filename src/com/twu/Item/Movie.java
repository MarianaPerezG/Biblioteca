package com.twu.Item;

public class Movie implements checkableItem {

    private String name;
    private String director;
    private int yearPublished;
    private float rate;
    public boolean available = true;

    public Movie(String name, String director, int yearPublished, float rate){
        this.name = name;
        this.director =  director;
        this.yearPublished = yearPublished;
        this.rate = rate;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setDirector (String director){
        this.director = director;
    }

    private void setYearPublished(int yearPublished){
        this.yearPublished = yearPublished;
    }

    public String getName(){
        return name;
    }

    public String getDirector(){
        return director;
    }

    public String getInfo(){
        return String.format("%s by %s. Year of Publish: %03d", this.getName(), this.getDirector(), this.getYearPublished());
    }

    public int getYearPublished(){
        return yearPublished;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkOut(){
        available = false;
    }

    public void checkIn(){
        available = true;
    }
}
