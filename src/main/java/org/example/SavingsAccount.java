package org.example;

import org.example.exceptions.InsufficientFundsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SavingsAccount extends Account implements IAccountInfo {

    private final double interestRate;
    private final String accountNumber;
    private List<Transaction> transactionHistory;

    private String accountHolder;

    private String currencyType;

    public SavingsAccount(double balance, double interestRate, String currencyType, boolean isActive, String accountHolder) {
        super(balance, currencyType, isActive, accountHolder);
        this.interestRate = interestRate;
        this.transactionHistory = new ArrayList<Transaction>();
        this.accountNumber = setAccountNumber();
        this.accountHolder = accountHolder;
        this.currencyType = currencyType;
    }


    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolderName() {
        return null;
    }

    @Override
    public String getCurrencyType() {
        return currencyType;
    }

    @Override
    public double getAccountBalance() {
        return getBalance();
    }

    private String setAccountNumber() {
        Random rand = new Random();
        String accountNumber = String.valueOf(rand.nextInt(900000000) + 100000000);
        return accountNumber;
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
        return "This savings account's balance is " +
                 balance +
                ".  The interest rate is " + interestRate +
                ". The currency is '" + currencyType + '\'' +
                ". The number of the account is '" + accountNumber + '\'' +
                ".  Is it active? " + isActive;
    }
}
