package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Cart {

    private static Scanner scan = new Scanner(System.in);
    private static boolean isComplete = false;
    private static int productIndex = 0;
    private static Product[] products = new Product[0];
    private static FidelityCard fidelityCard;

    public static void main(String[] args) {
        System.out.print("Hai la card fidelity card? Si/No ");
        String hasFidelityCardStr = scan.nextLine().trim();

        if (hasFidelityCardStr.toLowerCase().equals("si")) {
            System.out.print("Inserisci il numero di carta fedeltà? (esempio: 11111) ");
            int numberOfNumString = scan.nextInt();
            if (FidelityCard.checkNumberFidelityCard(numberOfNumString)) {
                fidelityCard = new FidelityCard(numberOfNumString);
            }
        }

        while (!isComplete) {
            System.out.print("Inserisci un prodotto tra Smartphone, Cuffie o Televisioni: ");
            String userAnswer = scan.nextLine();

            if (userAnswer.trim().toLowerCase().equals("smartphone")) {
                addSmartphone();
            } else if (userAnswer.trim().toLowerCase().equals("cuffie")) {
                addHeadphone();
            } else if (userAnswer.trim().toLowerCase().equals("televisione")) {
                addTV();
            } else {
                System.out.println("Inserisci un elemento tra Cuffie, Televisione o Smartphone");
            }
        }
        if (productIndex > 0) {
            showProducts();
            System.out.println("il prezzo finale è di:" + " " + checkout());
        }
    }

    private static void addSmartphone() {
        System.out.print("Inserisci il nome dello smartphone: ");
        String name = scan.nextLine();
        System.out.print("Inserisci il marchio dello smartphone: ");
        String brand = scan.nextLine();
        System.out.print("Inserisci il prezzo dello smartphone: ");
        String priceStr = scan.nextLine().trim();
        System.out.print("Con quanta memoria? ");
        int memorySize = scan.nextInt();

        if (name.isEmpty() || brand.isEmpty() || priceStr.isEmpty()) {
            System.out.println("Tutti i campi sono obbligatori!");
            return;
        }

        BigDecimal price = new BigDecimal(priceStr);

        if (price.compareTo(BigDecimal.ZERO) <= 0 || memorySize <= 0) {
            System.out.println("Prezzo e memoria devono essere maggiori di zero!");
            return;
        }

        Smartphone newSmartphone = new Smartphone(name, brand, price, memorySize);
        System.out.println(newSmartphone.toString());
        addProduct(newSmartphone);
        continueShop();
    }

    private static void addTV() {
        System.out.print("Inserisci il nome della televisione: ");
        String name = scan.nextLine();
        System.out.print("Inserisci il marchio della televisione: ");
        String brand = scan.nextLine();
        System.out.print("Inserisci il prezzo della televisione: ");
        String priceStr = scan.nextLine().trim();
        System.out.print("SMART (Se è smart scrivi Si)? ");
        String isSmartStr = scan.nextLine();
        System.out.print("Quanti pollici? ");
        int inches = scan.nextInt();

        boolean isSmart = false;

        if (isSmartStr.trim().toLowerCase().equals("si")) {
            isSmart = true;
        }

        if (name.isEmpty() || brand.isEmpty() || priceStr.isEmpty()) {
            System.out.println("Tutti i campi sono obbligatori!");
            return;
        }

        BigDecimal price = new BigDecimal(priceStr);

        if (price.compareTo(BigDecimal.ZERO) <= 0 || inches <= 0) {
            System.out.println("Prezzo e memoria devono essere maggiori di zero!");
            return;
        }

        TV newTV = new TV(name, brand, price, inches, isSmart);
        System.out.println(newTV.toString());
        addProduct(newTV);
        continueShop();
    }

    private static void addHeadphone() {
        System.out.print("Inserisci il nome delle cuffie: ");
        String name = scan.nextLine();
        System.out.print("Inserisci il marchio delle cuffie: ");
        String brand = scan.nextLine();
        System.out.print("Inserisci il prezzo delle cuffie: ");
        String priceStr = scan.nextLine().trim();
        System.out.print("Sono wirless (Se è wirless scrivi Si)? ");
        String isWirlessStr = scan.nextLine();
        System.out.print("Che colore? ");
        String color = scan.nextLine();

        boolean isWireless = false;

        if (isWirlessStr.trim().toLowerCase().equals("si")) {
            isWireless = true;
        }

        if (name.isEmpty() || brand.isEmpty() || priceStr.isEmpty() || color.isEmpty()) {
            System.out.println("Tutti i campi sono obbligatori!");
            return;
        }

        BigDecimal price = new BigDecimal(priceStr);

        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Prezzo e memoria devono essere maggiori di zero!");
            return;
        }

        Headphone newHeadphone = new Headphone(name, brand, price, color, isWireless);
        System.out.println(newHeadphone.toString());
        addProduct(newHeadphone);
        continueShop();
    }

    private static void addProduct(Product product) {
        Product[] newArray = new Product[productIndex + 1];

        for (int i = 0; i < productIndex; i++) {
            newArray[i] = products[i];
        }

        newArray[productIndex] = product;

        products = newArray;
        productIndex++;
    }

    private static void continueShop() {
        boolean righAnswer = true;
        while (righAnswer) {
            System.out.print("Vuoi continuare? Si/No ");
            String continueShopStr = scan.nextLine().trim();
            if (continueShopStr.toLowerCase().equals("no")) {
                isComplete = true;
                System.out.println("-----");
                righAnswer = false;
            } else if (continueShopStr.toLowerCase().equals("si")) {
                righAnswer = false;
            }
        }
    }

    public static BigDecimal checkout() {
        System.out.println("DEBUG: Calcolo sconti con fidelity card = "
                + (fidelityCard != null ? fidelityCard.haveDiscount : false));
        BigDecimal total = new BigDecimal("0");
        for (int i = 0; i < products.length; i++) {
            total = total.add(products[i].totalPrice(products[i].getPrice(), products[i].getTax(),
                    fidelityCard != null ? fidelityCard.haveDiscount : false));
        }

        return total;
    }

    public static void showProducts() {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].toString());
            System.out.println("-----");
        }
    }

}
