package org.example;

public abstract class Card implements ITransaction {
    protected final String cardNumber;
    private double availableFunds;

    public Card(String cardNumber, double availableFunds) {
        this.cardNumber = cardNumber;
        this.availableFunds = availableFunds;
    }

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return this.cardNumber;
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
