package org.lessons.java.shop;

import java.math.BigDecimal;

public class TV extends Product {
    private int inches;
    private boolean isSmart;

    public TV(String name, String brand, BigDecimal price, int inches, boolean isSmart) {
        super(name, brand, price);
        this.inches = inches;
        this.isSmart = isSmart;
    }

    // GETTER

    public int getInches() {
        return inches;
    }

    public boolean getIsSmart() {
        return isSmart;
    }

    // SETTER
    public void setInches(int inches) {
        if (inches > 0) {
            this.inches = inches;
        }
    }

    public void setSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

}
