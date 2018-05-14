package com.twu.Item;

public interface CheckableItem extends printableObject{

    void setCheckedOut();

    void setCheckedIn();

    boolean isAvailable();

}
