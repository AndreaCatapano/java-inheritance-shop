package org.lessons.java.shop;

import java.math.BigDecimal;
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

    protected void showInfoProduct() {
        System.out.println("Prodotto: " + getName() + " - " + getBrand());
        System.out.println("Prezzo: €" + getPrice() + " (tasse: " + getTax().multiply(new BigDecimal(100)) + "%)");
        System.out.println("Prezzo finale: €" + getPrice().add(getPrice().multiply(getTax())));
        System.out.println("S/N: " + getSerialNumber());
        System.out.println("---");
    }
}
