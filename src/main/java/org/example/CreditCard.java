package org.example;

public class CreditCard extends Card implements IRewards, ITransaction {
    private int rewardPoints = 0;

    //private = only accessible to the class' methods
    //final = cannot be changed later
    private final double creditLimit;

    public CreditCard(String cardNumber, double creditLimit) {
        super(cardNumber);
        this.creditLimit = creditLimit;
        this.rewardPoints = rewardPoints;
    }

    public final void withdraw(double amount) {
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

