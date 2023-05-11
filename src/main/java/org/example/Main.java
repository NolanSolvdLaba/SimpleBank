package org.example;

import org.example.enums.BranchType;
import org.example.enums.Department;
import org.example.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        System.out.println("-----------------------");

        //2. Consumer to change employee's department
        System.out.println("-----------------------");
        Employee johnnyTech = new Employee("Johnny Tech", 5_000, Department.IT);

        //consumer takes input and performs action on the input
        Consumer<Employee> changeDepartment = (employee) -> employee.setDepartment(Department.MARKETING);


        changeDepartment.accept(johnnyTech);
        System.out.println(johnnyTech.getDepartment());
        System.out.println("-----------------------");

        //3.
        System.out.println("-----------------------");
        System.out.println("-----------------------");
    }
}