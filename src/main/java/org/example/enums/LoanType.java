package org.example.enums;

public enum LoanType {
    AUTO(5.0),
    HOME(3.5),
    PERSONAL(7.0);

    private double interestRate;

    LoanType(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

