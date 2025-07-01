package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public String toString() {
        return super.toString() + "\n" +
                "Colore: " + getColor() + "\n" +
                "Wireless: " + (isWireless() ? "Sì" : "No");
    }

    @Override
    public BigDecimal totalPrice(BigDecimal price, BigDecimal tax, boolean hasFidelityCard) {
        BigDecimal priceTax = price.add(price.multiply(tax).setScale(2, RoundingMode.DOWN));

        if (!hasFidelityCard) {
            return priceTax;
        }

        BigDecimal discount = priceTax.multiply(new BigDecimal("0.02"));

        if (!isWireless) {
            discount = priceTax.multiply(new BigDecimal("0.07"));
        }
        return priceTax.subtract(discount).setScale(2, RoundingMode.DOWN);
    }
}
