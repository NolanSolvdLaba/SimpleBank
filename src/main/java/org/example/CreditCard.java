package org.example;

import org.example.exceptions.AuthenticationException;
import org.example.exceptions.InsufficientFundsException;

public class CreditCard extends Card implements IRewards, ITransaction {
    private int rewardPoints = 0;
    private final double creditLimit;

    private final int pin;

    public CreditCard(String cardNumber, double creditLimit, int pin) {
        super(cardNumber);
        this.creditLimit = creditLimit;
        this.rewardPoints = rewardPoints;
        this.pin = pin;
    }

    public boolean authenticate(int enteredPin) throws AuthenticationException {
        if (pin == enteredPin) {
            return true;
        } else {
            throw new AuthenticationException("Invalid PIN entered.");
        }
    }


    @Override
    public final void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= creditLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Transaction declined: Exceeds available funds and credit limit");
        }
    }

    @Override
    public int getPointsEarned(double amountSpent) {
        // Assume 1 reward point for every $10 spent
        int points = (int) (amountSpent / 10);
        rewardPoints += points;
        return points;
    }

    @Override
    public void redeemPoints(int pointsToRedeem) {
        // 1 point = $0.01
        double credit = pointsToRedeem * 0.01;
        deposit(credit);
        rewardPoints -= pointsToRedeem;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }
}

