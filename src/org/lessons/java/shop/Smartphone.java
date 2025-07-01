package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Smartphone extends Product {
    private long IMEIcode;
    private int memorySize;

    Random rand = new Random();

    public Smartphone(String name, String brand, BigDecimal price, int memorySize) {
        super(name, brand, price);
        this.IMEIcode = Math.abs(rand.nextLong() % (long) 1e15);
        this.memorySize = memorySize;
    }

    // GETTER

    public long getIMEIcode() {
        return IMEIcode;
    }

    public int getMemorySize() {
        return memorySize;
    }

    // SETTER

    public void setMemorySize(int memorySize) {
        if (memorySize > 0) {
            this.memorySize = memorySize;
        }
    }

    @Override
    public BigDecimal totalPrice(BigDecimal price, BigDecimal tax, boolean hasFidelityCard) {
        BigDecimal priceTax = price.add(price.multiply(tax).setScale(2, RoundingMode.DOWN));

        if (!hasFidelityCard) {
            return priceTax;
        }

        BigDecimal discount = priceTax.multiply(new BigDecimal("0.02"));

        if (memorySize <= 32) {
            discount = priceTax.multiply(new BigDecimal("0.05"));
        }
        return priceTax.subtract(discount).setScale(2, RoundingMode.DOWN);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "IMEI: " + getIMEIcode() + "\n" +
                "Memoria: " + getMemorySize() + "GB";
    }

}
