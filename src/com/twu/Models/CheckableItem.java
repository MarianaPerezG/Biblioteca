package com.twu.Models;

public interface CheckableItem extends PrintableObject {

    void setCheckedOut();

    void setCheckedIn();

    boolean isAvailable();

}
