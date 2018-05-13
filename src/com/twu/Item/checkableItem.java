package com.twu.Item;

public interface checkableObject extends printableObject{

    public void checkOut();

    public void checkIn();

    public boolean isAvailable();

}
