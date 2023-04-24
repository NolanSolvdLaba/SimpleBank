package org.example;

public abstract class Account {
    protected final String accountNumber;

    protected final String accountHolder;
    protected double balance;
    protected double interestRate;
    protected String accountType;
    protected boolean isActive;

    public Account(double balance, String accountType, String accountNumber, boolean isActive, String accountHolder) {
        this.balance = balance;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.isActive = isActive;
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}
