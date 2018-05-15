package com.twu.Models;

public class User {
    private String name;
    private String surname;
    private String libraryNumber;
    private String password;
    private String email;
    private String phone;

    public User(String name, String surname, String libraryNumber, String password, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
