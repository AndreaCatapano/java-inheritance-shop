package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {
    protected int serialNumber;
    protected String name;
    protected String brand;
    protected BigDecimal price;
    protected BigDecimal tax;

    Random rand = new Random();

    public Product(String name, String brand, BigDecimal price) {
        this.serialNumber = 100000 + rand.nextInt(999999);
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.tax = new BigDecimal("0.22");
    }

    public Product(String name, String brand, BigDecimal price, BigDecimal tax) {
        this.serialNumber = rand.nextInt(999999);
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.tax = tax;
    }

    // GETTER
    public int getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTax() {
        return tax;
    }

    // SETTER

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            this.price = price;
        }
    }

    public void setTax(BigDecimal tax) {
        if (price.compareTo(BigDecimal.ZERO) >= 0) {
            this.tax = tax;
        }
    }

    // UTILITY

    public BigDecimal totalPrice(BigDecimal price, BigDecimal tax, boolean hasFidelityCard) {
        BigDecimal priceTax = price.add(price.multiply(tax).setScale(2, RoundingMode.DOWN));

        if (!hasFidelityCard) {
            return priceTax;
        }

        BigDecimal discount = priceTax.multiply(new BigDecimal("0.02"));
        return priceTax.subtract(discount).setScale(2, RoundingMode.DOWN);
    }

    public String toString() {
        return String.format("Il nome del prodotto è %s del brand %s\n" +
                "Prezzo: €%s (tasse: %s%%)\n" +
                "Prezzo finale: €%s\n" +
                "S/N: %s",
                getName(),
                getBrand(),
                getPrice(),
                getTax().multiply(new BigDecimal(100)),
                totalPrice(price, tax, false),
                getSerialNumber());
    }
}
