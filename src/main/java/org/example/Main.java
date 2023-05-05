package org.example;

import org.example.exceptions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws LoanAmountException, CreditLowException, NonLatinateLetters, InsufficientFundsException, AuthenticationException {

        GenericLinkedList<Customer> sweepStakes = new GenericLinkedList<>();

        Customer billyBucks = new Customer("Billy", "Bucks");
        Customer maryMoneybags = new Customer("Mary", "Moneybags");
        Customer sammySketchy = new Customer("Sammy", "Sketchy");

        sweepStakes.add(billyBucks);
        sweepStakes.add(maryMoneybags);
        sweepStakes.add(sammySketchy);

        System.out.println("\n----------------------------------\n");
        logger.info("Printing out sweepStakes...");
        System.out.println(sweepStakes.toString());

        sweepStakes.remove(billyBucks);

        logger.info("Printing out sweepStakes having removed one member...");
        System.out.println(sweepStakes.toString());
        System.out.println("\n----------------------------------\n");

        //instantiating instances of CreditCard
        CreditCard firstCustomer = new CreditCard(10_000, 1234);
        CreditCard secondCustomer = new CreditCard(2_000, 1234);
        CreditCard thirdCustomer = new CreditCard(1_000, 1234);

        //getting all instances above
        Set<String> cardNumbers = CreditCard.getAllCardNumbers();

        //printing the instances
        logger.info("Printing cardNumbers...");
        for(String cardNumber: cardNumbers){
            System.out.println(cardNumber);
        }
        System.out.println("\n----------------------------------\n");

        //new bank branch
        Branch phillyBranch = new Branch("Philly Branch", "55 Broad Street");

        //adding 3 employees to the branch
        phillyBranch.addEmployee(new Employee("Asema", 4000, "IT"));
        phillyBranch.addEmployee(new Employee("Jenn", 4000, "Accounting"));
        phillyBranch.addEmployee(new Employee("Nolan", 1, "IT"));


        logger.info("Printing cardNumbers...");
        System.out.println(phillyBranch.searchEmployeesByDepartment("IT"));
        System.out.println(phillyBranch.searchEmployeesByDepartment("Accounting"));
        System.out.println("\n----------------------------------\n");

        //new Customer class implementing the accounts map in the Customer class
        Customer ericLindros = new Customer("Eric", "Lindros");

        //instantiating accounts for ericLindros (SavingsAccount class instantiation)
        SavingsAccount yenAccount = new SavingsAccount(1_000, .15, "Yen", true, ericLindros.getFullName());
        SavingsAccount pesoAccount = new SavingsAccount(1_000, .15, "Peso", true, ericLindros.getFullName());
        SavingsAccount euroAccount = new SavingsAccount(1_000, .15, "Euro", true, ericLindros.getFullName());

        //adding the accounts to ericLindros
        ericLindros.addAccount(yenAccount);
        ericLindros.addAccount(pesoAccount);
        ericLindros.addAccount(euroAccount);

        logger.info("Retrieving the 'Peso' account in ericLindros");
        System.out.println(ericLindros.getAccountByCurrency("Peso")+ "\n");
        logger.info("Retrieving the 'Peso' account in ericLindros");
        System.out.println(ericLindros.getAccountByCurrency("Shilling"));
        System.out.println("\n----------------------------------\n");

        //

        logger.info("Exiting the application");
    }
}