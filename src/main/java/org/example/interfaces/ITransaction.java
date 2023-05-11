package org.example.interfaces;

import org.example.exceptions.InsufficientFundsException;


public interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    double getBalance();

    // can be overridden by subclasses
    int getPointsEarned(double amountSpent);

    void redeemPoints(int pointsToRedeem);

}