package org.lessons.java.shop;

import java.math.BigDecimal;

public class Headphone extends Product {
    private String color;
    private boolean isWireless;

    public Headphone(String name, String brand, BigDecimal price, String color, boolean isWireless) {
        super(name, brand, price);
        this.color = color;
        this.isWireless = isWireless;

    }

    // GETTER

    public String getColor() {
        return color;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public boolean isWired() {
        return !isWireless;
    }

    // SETTER

    public void setColor(String color) {
        if (color != null) {
            this.color = color;
        }
    }

    public void setWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    @Override
    protected void showInfoProduct() {
        super.showInfoProduct();
        System.out.println("Color: " + getColor() + " Wireless: " + isWireless());
    }
}
