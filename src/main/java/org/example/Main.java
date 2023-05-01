package org.example;

import org.example.exceptions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws LoanAmountException, CreditLowException, NonLatinateLetters, InsufficientFundsException, AuthenticationException {
        logger.info("Starting the application");
        GenericLinkedList accountSignups = new GenericLinkedList();

        Customer billyBucks = new Customer("Billy Bucks");
        Customer maryMoneybags = new Customer("Mary Moneybags");
        Customer sammySketchy = new Customer("Sammy Sketchy");
        Customer vovanVovanovich = new Customer("Вован Вованович Копчак");

        accountSignups.add(billyBucks);
        accountSignups.add(maryMoneybags);
        accountSignups.add(sammySketchy);
        accountSignups.add(vovanVovanovich);

        for (int i = 0; i < accountSignups.size(); i++) {
            System.out.println(accountSignups.get(i));
        }

        logger.info("Exiting the application");
    }
}