package org.example;

public class SavingsAccount extends Account {
    public SavingsAccount(double balance, double interestRate, String accountType, String accountNumber, boolean isActive) {
        super(balance);
        this.interestRate = interestRate;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.isActive = isActive;
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
        return "SavingsAccount{" +
                "balance=" + balance +
                ", interestRate=" + interestRate +
                ", accountType='" + accountType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
