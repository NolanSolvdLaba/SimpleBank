package org.example;

import org.example.exceptions.NonLatinateLetters;

import java.util.Objects;

import static org.example.Main.logger;

public class Customer {
    private static int maxId = 0;
    private String name;
    private int id;

    static {
        // Code in this block executes when the class is loaded
        maxId = 1000;
    }

    public Customer(String name) throws NonLatinateLetters {
        try {
            if (!name.matches("\\p{IsLatin}+")) {
                throw new NonLatinateLetters("Custom's name must be represented in latinate letters.");
            }
            this.name = name;
            this.id = ++maxId;
        } catch (NonLatinateLetters e) {
            logger.error("Error creating customer: " + e.getMessage());
            throw e;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NonLatinateLetters {
        try {
            if (!name.matches("\\p{IsLatin}+")) {
                throw new NonLatinateLetters("Custom's name must be represented in latinate letters.");
            }
            this.name = name;
        } catch (NonLatinateLetters e) {
            logger.error("Error setting customer name: " + e.getMessage());
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
                name + '\'' +
                "and their id is " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}

