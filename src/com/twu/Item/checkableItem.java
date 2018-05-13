package com.twu.Item;

public interface checkableItem extends printableObject{

    void checkOut();

    void checkIn();

    boolean isAvailable();

}
