package org.example;

import org.example.exceptions.InsufficientFundsException;

public abstract class Account {
    protected double balance;
    protected boolean isActive;

    protected final String currencyType;

    public Account(double balance, String accountType, boolean isActive, String currencyType) {
        this.balance = balance;
        this.isActive = isActive;
        this.currencyType = currencyType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public abstract String getAccountNumber();


    public abstract void deposit(double amount);

    public abstract void withdraw(double amount) throws InsufficientFundsException;
}
