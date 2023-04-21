package org.example;
/*
 One private field: bal   
*/
 
public class Account {
    private double balance;

    public Account() {}

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
