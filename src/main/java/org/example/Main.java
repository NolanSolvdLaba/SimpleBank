package org.example;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Customer nolan = new Customer("Nolan Geiger", 53);
        System.out.println(nolan.getName());

        CreditReport riskyCustomer = new CreditReport(400, 100, 2);
        System.out.println(riskyCustomer);

        Approval nolanLoan = new Approval(nolan, 780);
        System.out.println(nolanLoan.getCreditRating());

        Employee bankBoss = new Employee("Mr. Eugene", 500000);
        System.out.println(bankBoss.getSalary());

        Transaction amazonPurchase = new Transaction(new Date(), 55.00);
        System.out.println(amazonPurchase.getDate());

        Card freeMoney = new Card("1001415756667575");
        System.out.println(freeMoney.getCardNumber());

        Account account = new Account();
        System.out.println(account.getBalance());

        Branch phillyBranch = new Branch("Broadstreet Branch", "3601 S Broad St, Philadelphia, PA 19148");
        System.out.println(phillyBranch.getLocation());

        Loan myLoan = new Loan(20_000);
        System.out.println(myLoan.getAmount());
    }
}