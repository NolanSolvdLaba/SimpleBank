package org.example;

import org.example.exceptions.CreditLowException;

public class CreditReport {
    private int creditScore;
    private int numLatePayments;
    private int numAccounts;

    public CreditReport(int creditScore, int numLatePayments, int numAccounts) throws CreditLowException {
        setCreditScore(creditScore);
        setNumLatePayments(numLatePayments);
        setNumAccounts(numAccounts);
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) throws CreditLowException {
        if (creditScore < 300) {
            throw new CreditLowException("Credit score is too low.");
        }
        this.creditScore = creditScore;
    }

    public int getNumLatePayments() {
        return numLatePayments;
    }

    public void setNumLatePayments(int numLatePayments) {
        this.numLatePayments = numLatePayments;
    }

    public int getNumAccounts() {
        return numAccounts;
    }

    public void setNumAccounts(int numAccounts) {
        this.numAccounts = numAccounts;
    }
}
