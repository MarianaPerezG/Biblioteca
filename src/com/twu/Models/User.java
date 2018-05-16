package com.twu.Models;

public class User {
    private String name;
    private String surname;
    private String libraryNumber;
    private String password;
    private String email;
    private String phone;
    private boolean admin;
    private boolean loggedIn;

    public User(String name, String surname, String libraryNumber, String password, String email, String phone, boolean admin) {
        this.name = name;
        this.surname = surname;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.admin = admin;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getInfo(){

        return String.format("Name: %s %s  |   email: %s  |   phone: %s", this.getName(), this.getSurname(),this.getEmail(), this.getPhone());
    }

    public boolean isPasswordCorrect(String passwordToCheck){
        return passwordToCheck.equals(this.password);
    }

    public void logIn(){
        this.loggedIn = true;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void logOut(){
        this.loggedIn = false;
    }

    public boolean isAdmin(){
        return admin;
    }


}
