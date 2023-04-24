package org.example;

public class Card implements ITransaction {
    private String cardNumber;
    private double availableFunds;

    public Card(String cardNumber, double availableFunds) {
        this.cardNumber = cardNumber;
        this.availableFunds = availableFunds;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    @Override
    public void deposit(double amount) {
        availableFunds += amount;
    }

    @Override
    public void withdraw(double amount) {
        availableFunds -= amount;
    }

    @Override
    public double getBalance() {
        return availableFunds;
    }
}
