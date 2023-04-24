package org.example;

public class SavingsAccount extends Account implements IAccountInfo{
    public SavingsAccount(double balance, double interestRate, String accountType, String accountNumber, boolean isActive, String accountHolder) {
        super(balance, accountType, accountNumber, isActive, accountHolder);
        this.interestRate = 0.1;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolder;
    }

    @Override
    public String getAccountType() {
        return accountType;
    }

    @Override
    public double getAccountBalance() {
        return getBalance();
    }

    @Override
    public void deposit(double amount) {
        double currentBalance = getBalance();
        setBalance(currentBalance + amount);
    }

    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        setBalance(currentBalance - amount);
    }

    @Override
    public String toString() {
        return "This savings account's balance is" +
                 balance +
                ".  The interest rate is " + interestRate +
                ". The type is '" + accountType + '\'' +
                ". The number of the account is '" + accountNumber + '\'' +
                ".  Is it active? " + isActive;
    }
}
