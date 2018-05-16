package com.twu.Models;
import java.util.Date;

public class Loan {
    private User user;
    private CheckableItem item;
    private Date date;

    public Loan(User user, CheckableItem item){
        this.user = user;
        this.item = item;
        this.date = new Date();
    }

    public User getUser() {
        return user;
    }

    public CheckableItem getItem() {
        return item;
    }

    public Date getDate() {
        return date;
    }

}
