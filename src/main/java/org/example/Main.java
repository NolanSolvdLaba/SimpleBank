package org.example;

import org.example.exceptions.CreditLowException;
import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.LoanAmountException;
import org.example.exceptions.NonLatinateLetters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws LoanAmountException, CreditLowException, NonLatinateLetters, InsufficientFundsException {

        //Logging via Card class
        CreditCard spendAlot = new CreditCard("1150", 10_000, 1234);
        spendAlot.withdraw(10100);


        //Try with resources: wrong filename
        String fileName = "data/sample.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("Name: " + values[0] + ", Age: " + values[1]);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        //Try with resources: correct filename
        String correctFile = "src/data/example.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(correctFile))) {
            String newLine;
            while ((newLine = br.readLine()) != null) {
                String[] values = newLine.split(",");
                System.out.println("Name: " + values[0] + ", Age: " + values[1]);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        //try catch block
        try {
            Branch newyorkBranch = new Branch("5th Ave Branch", "555 5th Avenue, New York, NY 10110");
            System.out.println("New York branch location: " + newyorkBranch.getLocation());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }


        //succcesful implementation of a customer and implementation of the toString method
        Customer nolan = new Customer("NolanGeiger");
        System.out.println("Customer's information is: " + nolan.toString());

//        //unsuccessful imlementation of a customer and implementation of the toString method
//        //the instantiation throws the NonLatinateLetters exception
//        Customer solarisAuthor = new Customer("Stanisław Lem");
//        System.out.println("Customer's information is: " + solarisAuthor.toString());


        //unsuccessful instantatiation of a customer
        //throws the custom exception CreditLowException
        try {
            CreditReport riskyCustomer = new CreditReport(250, 2, 5);
            System.out.println(riskyCustomer.getCreditScore());
        } catch (CreditLowException e) {
            System.out.println("Error: " + e.getMessage());
        }


        try {
            Loan myLoan = new Loan(0, 0.15, 60);
        } catch (LoanAmountException e) {
            System.out.println(e.getMessage());
        }


        Employee bankBoss = new Employee("Mr. Eugene", 500000);
        System.out.println(bankBoss.getSalary());

        CreditCard freeMoney = new CreditCard("1001415756667575", 10_000.00, 1234);
        System.out.println(freeMoney.getCardNumber());

        SavingsAccount accountSavings = new SavingsAccount(300, 2.0, "Money market", "55",true, "Billy Big Bucks");
        System.out.println("Savings account balance is: " + accountSavings.getBalance());
    }
}