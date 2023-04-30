package org.example;

import org.example.exceptions.InsufficientFundsException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class Card implements ITransaction {
    private static final Logger logger = LogManager.getLogger(Card.class);
    protected final String cardNumber;
    private double availableFunds;

    public Card(String cardNumber, double availableFunds) {
        this.cardNumber = cardNumber;
        this.availableFunds = availableFunds;
    }

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }


    @Override
    public void deposit(double amount) {
        availableFunds += amount;
        logger.info("Successfully deposited amount: {}", amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > availableFunds) {
            logger.error("Insufficient funds to withdraw amount: ", amount);
            throw new InsufficientFundsException();
        } else {
            availableFunds -= amount;
            logger.info("Successfully withdrew amount: ", amount);
        }

    }

    @Override
    public double getBalance() {
        logger.info("Retrieved balance: ", availableFunds);
        return availableFunds;
    }

}
