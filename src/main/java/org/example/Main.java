package org.example;

import org.example.exceptions.CreditLowException;
import org.example.exceptions.LoanAmountException;

public class Main {
    public static void main(String[] args) throws LoanAmountException, CreditLowException {
        Branch phillyBranch = new Branch("Broadstreet Branch", "3601 S Broad St, Philadelphia, PA 19148");
        System.out.println(phillyBranch.getLocation());

        try {
            Branch newyorkBranch = new Branch("5th Ave Branch", "555 5th Avenue, New York, NY 10110");
            System.out.println("New York branch location: " + newyorkBranch.getLocation());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        Customer nolan = new Customer("Nolan Geiger", 53);
        System.out.println("Customer's information is: " + nolan.toString());

        try {
            CreditReport riskyCustomer = new CreditReport(250, 2, 5);
            System.out.println(riskyCustomer.getCreditScore());
        } catch (CreditLowException e) {
            System.out.println("Error: " + e.getMessage());
        }


        Employee bankBoss = new Employee("Mr. Eugene", 500000);
        System.out.println(bankBoss.getSalary());

        CreditCard freeMoney = new CreditCard("1001415756667575", 10_000.00, 1234);
        System.out.println(freeMoney.getCardNumber());

        SavingsAccount accountSavings = new SavingsAccount(300, 2.0, "Money market", "55",true, "Billy Big Bucks");
        System.out.println("Savings account balance is: " + accountSavings.getBalance());

        try {
            Loan myLoan = new Loan(0, 0.15, 60);
        } catch (LoanAmountException e) {
            System.out.println(e.getMessage());
        }

    }
}