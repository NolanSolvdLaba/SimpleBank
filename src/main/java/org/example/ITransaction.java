package org.example;

public interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();

    // can be overridden by subclasses
    int getPointsEarned(double amountSpent);

    void redeemPoints(int pointsToRedeem);
}