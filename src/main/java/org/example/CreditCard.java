package org.example;

public class CreditCard {
    private String cardNumber;
    private int creditLimit;

    public CreditCard(String cardNumber, int creditLimit) {
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
    }

    // Getters and setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }
}
