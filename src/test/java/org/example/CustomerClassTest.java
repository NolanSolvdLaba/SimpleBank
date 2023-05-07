package org.example;

import org.example.exceptions.NonLatinateLetters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Map;

public class CustomerClassTest {
    @Test
    public void testInstantiationTimeout() throws NonLatinateLetters {
        assertTimeout(Duration.ofSeconds(60), () -> {
            Customer slowTurtle = new Customer("Slow", "Turtle");
        });
    }

    @Test
    public void testSetFirstName() throws NonLatinateLetters {
        //creating a customer
        Customer tarasShevchenko = new Customer("Taras", "Shevchenko");

        //Verifying the setFirstName will return the received name
        assertEquals("Taras Shevchenko", tarasShevchenko.getFirstName());
    }

    @Test
    public void testGetAccounts() throws NonLatinateLetters {
        //instantiating customer
        Customer tommyCash = new Customer("Tommy", "Cash");

        //instantiating three accounts
        // three currency types: Euros, Dollars, Yeniz
        Account euros = new SavingsAccount(10_000, .15, "Euros", true, "Tommy Cash");
        Account dollars = new SavingsAccount(10_000, .15, "Dollars", true, "Tommy Cash");
        Account yeniz = new SavingsAccount(10_000, .15, "Yeniz", true, "Tommy Cash");

        //adding three acounts to the customer instance
        tommyCash.addAccount(euros);
        tommyCash.addAccount(dollars);
        tommyCash.addAccount(yeniz);

        //retrieving accounts using getAccounts()
        Map <String, Account> accounts = tommyCash.getAccounts();

        //using assertions to verify the accounts

        //checking that accounts map isn't null
        assertNotNull(accounts);

        //check the size of the accounts map
        assertEquals(3, accounts.size());

        //check if the map contains euros
        assertTrue(accounts.containsKey("Euros"));

        //check if the map contains dollars
        assertTrue(accounts.containsKey("Dollarys"));

        //check if the map contains Yen
        assertTrue(accounts.containsKey("Yen"));


    }

}
