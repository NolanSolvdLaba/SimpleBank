package org.example;

import org.example.exceptions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws LoanAmountException, CreditLowException, NonLatinateLetters, InsufficientFundsException, AuthenticationException {
        logger.info("Starting the application");
        GenericLinkedList<Customer> sweepStakes = new GenericLinkedList<>();

        try {
            Customer billyBucks = new Customer("Billy Bucks");
            Customer maryMoneybags = new Customer("Mary Moneybags");
            Customer sammySketchy = new Customer("Sammy Sketchy");
            Customer ivanoStanislavov = new Customer("Ivano Stanisławów");

            sweepStakes.add(billyBucks);
            sweepStakes.add(maryMoneybags);
            sweepStakes.add(sammySketchy);
            sweepStakes.add(ivanoStanislavov);
        } catch (NonLatinateLetters e) {
            logger.error("Error creating customer: " + e.getMessage());
        }

        //logs an error becuase sweepStakes.add(invanoStanislavov)
        //violates the NonLatinateLetters exception
        for (int i = 0; i < sweepStakes.size(); i++) {
            System.out.println(sweepStakes.get(i));
        }

        //instantiating instances of CreditCard
        CreditCard firstCustomer = new CreditCard(10_000, 1234);
        CreditCard secondCustomer = new CreditCard(2_000, 1234);
        CreditCard thirdCustomer = new CreditCard(1_000, 1234);

        //getting all instances above
        Set<String> cardNumbers = CreditCard.getAllCardNumbers();

        //printing the instances
        for(String cardNumber: cardNumbers){
            System.out.println(cardNumber);
        }



        logger.info("Exiting the application");
    }
}