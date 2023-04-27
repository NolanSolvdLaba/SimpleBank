package org.example;

import org.example.exceptions.LoanAmountException;

public class Loan {
    private double amount;
    private double interestRate;
    private int term;

    public Loan(double amount, double interestRate, int term) throws LoanAmountException {
        if (amount <= 0) {
            throw new LoanAmountException("Loan amount must be positive");
        }
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

