package org.example;

import org.example.exceptions.InsufficientFundsException;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account implements IAccountInfo {
    private final double interestRate;
    private List<Transaction> transactionHistory;

    public SavingsAccount(double balance, double interestRate, String accountType, String accountNumber, boolean isActive, String accountHolder) {
        super(balance, accountType, accountNumber, isActive, accountHolder);
        this.interestRate = 0.1;
        this.transactionHistory = new ArrayList<>();
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
        transactionHistory.add(new Transaction(amount));
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        double currentBalance = getBalance();
        if (currentBalance < amount) {
            throw new InsufficientFundsException();
        }
        setBalance(currentBalance - amount);
        transactionHistory.add(new Transaction(amount));
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
