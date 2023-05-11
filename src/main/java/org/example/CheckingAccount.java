package org.example;

public class CheckingAccount extends Account {

    private double overdraftLimit;


    public CheckingAccount(double balance, double overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance + overdraftLimit) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
        }
    }

}