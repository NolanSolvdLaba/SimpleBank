package org.example;

import org.example.exceptions.AuthenticationException;
import org.example.exceptions.InsufficientFundsException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CreditCard extends Card implements IRewards, ITransaction {

    private static final Set<String> cardNumbers = new HashSet<>();
    /*
    i.) Set is static and final so that the CreditCard class
    itself contains all cardNumbers.
    ii.) HashSet chosen over TreeSet or LinkedHashSet for instance
    because order of cardNumbers isn't relevant for the given class.
    iii.) 'cardNumbers' collection is 'static' and 'final'
    to ensure that all instances of 'CreditCard' are shared among the 'CreditCard' class
    and are unmodifiable.
    */
    private static final Logger logger = LogManager.getLogger(CreditCard.class);
    private int rewardPoints = 0;
    private final double creditLimit;
    private final int pin;

    public CreditCard(double creditLimit, int pin) {
        super(generateUniqueCardNumber());
        this.creditLimit = creditLimit;
        this.rewardPoints = rewardPoints;
        this.pin = pin;
    }

    private static String generateUniqueCardNumber() {
        String cardNumber;
        do {
            // Generate random 16-digit number
            cardNumber = String.format("%016d", new Random().nextLong() % 10000000000000000L);
        } while (cardNumbers.contains(cardNumber) || cardNumber.startsWith("-")); // Loop until unique number is found
        cardNumbers.add(cardNumber); // Add to list of existing card numbers
        return cardNumber;
    }

    public boolean authenticate(int enteredPin) throws AuthenticationException {
        if (pin == enteredPin) {
            return true;
        } else {
            String errorMessage = "Invalid PIN entered.";
            logger.error(errorMessage);
            throw new AuthenticationException(errorMessage);
        }
    }


    @Override
    public final void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= creditLimit) {
            super.withdraw(amount);
            logger.info("Transaction of " + amount + " has been successfully processed.");
        } else {
            logger.warn("Transaction declined: Exceeds available funds and credit limit.");
            System.out.println("Transaction declined: Exceeds available funds and credit limit.");
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

    public static Set<String> getAllCardNumbers() {
        return Collections.unmodifiableSet(cardNumbers);
    }
}

