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

    public String getInfoAdmin(){

        return String.format("User: %s    Item: %s ", this.user.getInfo(), this.item.getInfo() );
    }

    public String getInfo(){
        return String.format("%s ", this.item.getInfo() );
    }

}
