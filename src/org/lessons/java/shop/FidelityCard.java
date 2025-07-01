package org.lessons.java.shop;

public class FidelityCard {
    private int numberOfFidelyCard;
    boolean haveDiscount;
    public static FidelityCard[] list = {
            new FidelityCard(12345),
            new FidelityCard(67890),
            new FidelityCard(11111),
            new FidelityCard(22222)
    };

    FidelityCard(int numberOfFidelyCard) {
        this.numberOfFidelyCard = numberOfFidelyCard;
        this.haveDiscount = true;
    }

    public int getNumberOfFidelyCard() {
        return numberOfFidelyCard;
    }

    public boolean isHaveDiscount() {
        return haveDiscount;
    }

    public void setNumberOfFidelyCard(int numberOfFidelyCard) {
        this.numberOfFidelyCard = numberOfFidelyCard;
    }

    public static boolean checkNumberFidelityCard(int number) {

        for (int i = 0; i < list.length; i++) {
            if (number == list[i].numberOfFidelyCard) {
                System.out.println("codice corretto");
                return true;
            }
        }

        System.out.println("codice errato");
        return false;
    }
}
