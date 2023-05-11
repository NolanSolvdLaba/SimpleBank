package org.example;

public class SavingsAccount extends Account {

    public SavingsAccount(double balance) {
        super(balance);
    }

    public void deposit(double amount){
        balance += amount;
    }

    @Override
    public String toString() {
        return "This savings account's balance is " +
                 balance;
    }
}
