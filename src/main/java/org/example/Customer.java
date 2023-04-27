package org.example;

import org.example.exceptions.NonLatinateLetters;

import java.util.Objects;

public class Customer {
    private String name;
    private int id;

    public Customer(String name, int id) throws NonLatinateLetters {
        if (!name.matches("\\p{IsLatin}+")) {
            throw new NonLatinateLetters("Custom's name must be represented in latinate letters.");
        }
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NonLatinateLetters {
        if (!name.matches("\\p{IsLatin}+")) {
            throw new NonLatinateLetters("Custom's name must be represented in latinate letters.");
        }
        this.name = name;
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

