package com.twu.Item;

public interface CheckableItem extends PrintableObject {

    void setCheckedOut();

    void setCheckedIn();

    boolean isAvailable();

}
