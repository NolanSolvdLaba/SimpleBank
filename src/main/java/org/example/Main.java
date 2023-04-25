package org.example;

public class Main {
    public static void main(String[] args) {
        Branch phillyBranch = new Branch("Broadstreet Branch", "3601 S Broad St, Philadelphia, PA 19148");
        System.out.println(phillyBranch.getLocation());

        Branch newyorkBranch = new Branch("5th Ave Branch", "555 5th Avenue, New York, NY 10110");
        System.out.println("Are the two branches equal? " + phillyBranch.equals(newyorkBranch));

        Customer nolan = new Customer("Nolan Geiger", 53);
        System.out.println("Customer's information is: " + nolan.toString());

        CreditReport riskyCustomer = new CreditReport(400, 100, 2);
        System.out.println(riskyCustomer.getCreditScore());

        Employee bankBoss = new Employee("Mr. Eugene", 500000);
        System.out.println(bankBoss.getSalary());

        CreditCard freeMoney = new CreditCard("1001415756667575", 10_000.00, 1234);
        System.out.println(freeMoney.getCardNumber());

        SavingsAccount accountSavings = new SavingsAccount(300, 2.0, "Money market", "55",true, "Billy Big Bucks");
        System.out.println("Savings account balance is: " + accountSavings.getBalance());

        Loan myLoan = new Loan(20_000);
        System.out.println(myLoan.getAmount());
    }
}