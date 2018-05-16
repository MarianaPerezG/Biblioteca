package com.twu.Models;

public class Loan {
    private User user;
    private CheckableItem item;

    public Loan(User user, CheckableItem item){
        this.user = user;
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public CheckableItem getItem() {
        return item;
    }


    public boolean isLoan(User user, CheckableItem item) {

        if(user == this.getUser() && item == this.getItem()  ){
            return true;
        }

        return false;
    }

}
