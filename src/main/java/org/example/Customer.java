package org.example;

import org.example.exceptions.NonLatinateLetters;

import java.util.Objects;

import static org.example.Main.logger;

public class Customer {


    private static int maxId = 0;
    private String firstName;
    private String lastName;
    private int id;

    static {
        // Code in this block executes when the class is loaded
        maxId = 1000;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws NonLatinateLetters {
        try {
            if (!firstName.matches("\\p{IsLatin}+")) {
                throw new NonLatinateLetters("Customer's first name must be represented in latinate letters.");
            }
            this.firstName = firstName;
        } catch (NonLatinateLetters e) {
            logger.error("Error setting customer first name: " + e.getMessage());
            throw e;
        }
    }

    public Customer(String firstName, String lastName) throws NonLatinateLetters {
        try {
            if (!firstName.matches("\\p{IsLatin}+") || !lastName.matches("\\p{IsLatin}+")) {
                throw new NonLatinateLetters("Custom's name must be represented in latinate letters.");
            }
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = ++maxId;
        } catch (NonLatinateLetters e) {
            logger.error("Error creating customer: " + e.getMessage());
            throw e;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "the name of the customer is " +
                firstName + " " +lastName + '\'' +
                "and their id is " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }
}

