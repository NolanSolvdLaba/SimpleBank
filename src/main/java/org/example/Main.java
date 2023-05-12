package org.example;

import org.example.enums.BranchType;
import org.example.enums.Department;
import org.example.exceptions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws LoanAmountException, CreditLowException, NonLatinateLetters, InsufficientFundsException, AuthenticationException {
        //3 Custom lambdas

        //1. Filter branches by type with Predicate
        System.out.println("-----------------------");
        List<Branch> branches = new ArrayList<>();
        branches.add(new Branch("33 S Broad St", BranchType.KIOSK));
        branches.add(new Branch("40 S Broad St", BranchType.BUSINESS_BRANCH));
        branches.add(new Branch("3601 S Broad St", BranchType.KIOSK));

        Predicate<Branch> filterByType = (branch) -> branch.getBranchType() == BranchType.KIOSK;
        branches.stream()
                .filter(filterByType)
                .forEach(System.out::println);
        System.out.println("----------------------\n");

        //2. Consumer to change employee's department
        System.out.println("-----------------------");
        Employee johnnyTech = new Employee("Johnny Tech", 5_000, Department.IT);

        //consumer takes input and performs action on the input
        Consumer<Employee> changeDepartment = (employee) -> employee.setDepartment(Department.MARKETING);


        changeDepartment.accept(johnnyTech);
        System.out.println(johnnyTech.getDepartment());
        System.out.println("-----------------------\n");

        //3. Comparator to compare two employees' salaries
        System.out.println("-----------------------");
        Employee mikeyMarkets = new Employee("Mikey Markets", 5_000, Department.MARKETING);
        Employee frannyFinance = new Employee("Franny Finance", 7_000, Department.FINANCE);

        Comparator<Employee> compareSalaries = Comparator.comparingDouble(Employee::getSalary);
        int resultOfComparison = compareSalaries.compare(mikeyMarkets, frannyFinance);

        if (resultOfComparison < 0) {
            System.out.println(mikeyMarkets.getName() + " makes more money");
        } else if (resultOfComparison > 0) {
            System.out.println(frannyFinance.getName() + " makes more money");
        } else {
            System.out.println("Both employees make the same amount of money");
        }
        System.out.println("-----------------------\n");

        //5 lambda functions from java.util.function

        //Using BiPredicate to qualify a client as VIP
        BiPredicate<Double, Double> vipClientCondition = (checkingBalance, savingsBalance) ->
                checkingBalance > 10_000 || savingsBalance > 50_000;

        //Using Supplier to make a new Branch
        Supplier<Branch> branchSupplier = () -> new Branch("123 Nice Street", BranchType.KIOSK);

        //Using Predicate to qualify a no interest loan
        Predicate<Loan> noInterestLoan = l -> l.getInterestRate() == 0;

        //Using UnaryOperator to add bonus money to client's checking account
        UnaryOperator<CheckingAccount> signupBonus = account -> {
                account.setBalance(account.getBalance() + 100);
                return account;
        };

        //Using BiConsumer to display a message
        BiConsumer<String, Integer> printWelcome = (branch, nasdaq) -> {
            System.out.println("Welcome to " + branch + "!");
            System.out.println("Today's Nasdaq index is " + nasdaq + ".");
        };
        Branch bullyStreet = new Branch("222 Broad Street", BranchType.RETAIL_BRANCH);
        printWelcome.accept(bullyStreet.getLocation(), 4_756);

    }
}