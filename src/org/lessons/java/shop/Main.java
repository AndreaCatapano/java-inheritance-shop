package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Smartphone iphone = new Smartphone("iphone 14", "apple", new BigDecimal("999"), 64);
        TV smartSamsung = new TV("samsung full hd", "samsung", new BigDecimal("2999"), 60, true);
        Headphone airpods = new Headphone("airpods", "apple", new BigDecimal("199"), "white", true);

        System.out.println(iphone);
        System.out.println(smartSamsung);
        System.out.println(airpods);

    }
}
