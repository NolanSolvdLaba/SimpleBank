package org.example;

import org.example.exceptions.NonLatinateLetters;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Customer {
    private String firstName;
    private String lastName;
    private int id;
    private Map<String, Account> accounts;
    private static int counter;
    static {
        // Code in this block executes when the class is loaded
        counter = 1000;
    }

    public Customer(String firstName, String lastName) throws NonLatinateLetters {
        try {
            if (!firstName.matches("\\p{IsLatin}+") || !lastName.matches("\\p{IsLatin}+")) {
                throw new NonLatinateLetters("Custom's name must be represented in latinate letters.");
            }
            this.firstName = firstName;
            this.lastName = lastName;
            id = counter++;
            this.accounts = new HashMap<>();
        } catch (NonLatinateLetters e) {
            System.out.println("Error creating customer: " + e.getMessage());
            throw e;
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        String fullName = firstName + ' ' + lastName;
        return fullName;
    }

    public void setFirstName(String firstName) throws NonLatinateLetters {
        try {
            if (!firstName.matches("\\p{IsLatin}+")) {
                throw new NonLatinateLetters("Customer's first name must be represented in latinate letters.");
            }
            this.firstName = firstName;
        } catch (NonLatinateLetters e) {
            System.out.println("Error setting customer first name: " + e.getMessage());
            throw e;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }


    @Override
    public String toString() {
        String str = "Customer: " + firstName + " " + lastName + " (ID: " + id + ")\n";
        str += "Accounts:\n";
        for (Account account : accounts.values()) {
            str += account + "\n";
        }
        return str;
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

