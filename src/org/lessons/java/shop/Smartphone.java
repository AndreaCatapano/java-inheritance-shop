package org.lessons.java.shop;

import java.math.BigDecimal;
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

}
