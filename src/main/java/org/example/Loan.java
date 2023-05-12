package org.example;

import org.example.enums.LoanType;
import org.example.exceptions.LoanAmountException;

public class Loan {
    private double amount;
    private LoanType loanType;
    private int term;

    public Loan(double amount, LoanType loanType, int term) throws LoanAmountException {
        if (amount <= 0) {
            throw new LoanAmountException("Loan amount must be positive");
        }
        this.amount = amount;
        this.loanType = loanType;
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LoanType getLoanType(){
        return loanType;
    }
    public double getInterestRate() {
        return loanType.getInterestRate();
    }

    public int getTerm(){
        return term;
    }
}

