package org.example;

import org.example.enums.BranchType;
import org.example.enums.Department;
import org.example.exceptions.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws LoanAmountException, CreditLowException, NonLatinateLetters, InsufficientFundsException, AuthenticationException {
        // 7 Streams with terminal and non-terminal operations

        // STREAM 1: Creating a COLLECTION of branches and using a STREAM to print each
        System.out.println("-----------------------");
        List<Branch> branches = new ArrayList<>();
        branches.add(new Branch("33 S Broad St", BranchType.KIOSK));
        branches.add(new Branch("40 S Broad St", BranchType.BUSINESS_BRANCH));
        branches.add(new Branch("3601 S Broad St", BranchType.KIOSK));

        // Defining the predicate for filtering
        Predicate<Branch> filterByType = (branch) -> branch.getBranchType() == BranchType.KIOSK;

        // Using a stream to print each branch of type KIOSK
        branches.stream()
                .filter(filterByType)
                .forEach(System.out::println);
        System.out.println("----------------------\n");

        // STREAM 2: Department.java (enum) includes a stream
        System.out.println("-----------------------");
        for (Department department : Department.values()) {
            System.out.printf("Department %-20s Abbreviation: %s\n", department.getDepartmentName(), department.getAbbreviation());
        }
        System.out.println("----------------------\n");

        // Creating a collection for more streams: a list of employees
        List<Employee> employees = new ArrayList<>();

        // Instantiating employees
        Employee johnnyTech = new Employee("Johnny Tech", 5_000, Department.IT);
        Employee chrissyComputers = new Employee("Chrissy Computers", 3_000, Department.IT);
        Employee mikeyMarkets = new Employee("Mikey Markets", 5_000, Department.MARKETING);
        Employee frannyFinance = new Employee("Franny Finance", 7_000, Department.FINANCE);

        // Adding employees to the employees list
        employees.add(johnnyTech);
        employees.add(chrissyComputers);
        employees.add(mikeyMarkets);
        employees.add(frannyFinance);

        // STREAM 3: Filtering employees who are in the IT department
        System.out.println("-----------------------");
        List<Employee> itEmployees = employees.stream()
                .filter(emp -> emp.getDepartment() == Department.IT)
                .collect(Collectors.toList());
        System.out.println("Employees who are in the IT Department: " + itEmployees);
        System.out.println("-----------------------\n");

        // STREAM 4: Sorting employees by salary
        System.out.println("-----------------------");
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("Employees sorted by salary: " + sortedBySalary);
        System.out.println("-----------------------\n");

        // STREAM 5: Applying a functional interface to a stream and changing their department based on salary
        System.out.println("-----------------------");

        Consumer<Employee> changeDepartment = (employee) -> employee.setDepartment(Department.MARKETING);

        double salaryThreshold = 5000.0;
        employees.stream()
                .filter(employee -> employee.getSalary() > salaryThreshold)
                .forEach(changeDepartment);

        employees.forEach(employee -> {
            System.out.println(employee.getName() + " - " + employee.getDepartment());
        });
        System.out.println("-----------------------\n");

        // STREAM 6: Finding the highest paid employee
        System.out.println("-----------------------");
        Employee highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Highest paid employee: " + highestPaid);
        System.out.println("-----------------------\n");

        // STREAM 7: Counting the number of employees in the Marketing Department
        System.out.println("-----------------------");
        long numOfMarketingEmployees = employees.stream()
                .filter(emp -> emp.getDepartment() == Department.MARKETING)
                .count();
        System.out.println("Number of employees in the marketing department: " + numOfMarketingEmployees);
        System.out.println("-----------------------\n");

        // USING REFLECTION
        // Getting the Card Class
        Class<?> cardClass = Card.class;
        System.out.println(cardClass);

        // Getting the Card Class' fields (which contain private and protected fields)
        Field[] cardFields = cardClass.getDeclaredFields();

        System.out.println("Card Class' protected fields: ");
        Arrays.stream(cardFields)
                .filter(field -> Modifier.isProtected(field.getModifiers()))
                .forEach(field -> {
                    System.out.println("Name: " + field.getName());
                    System.out.println("Type: " + field.getType());
                    System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
                    System.out.println("-----------------------");
                });

        System.out.println("Card Class' private fields: ");
        Arrays.stream(cardFields)
                .filter(field -> Modifier.isPrivate(field.getModifiers()))
                .forEach(field -> {
                    System.out.println("Name: " + field.getName());
                    System.out.println("Type: " + field.getType());
                    System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
                    System.out.println("-----------------------");
                });

        // Getting all methods
        Method[] cardMethods = cardClass.getMethods();

        System.out.println("Card class' methods");
        Arrays.stream(cardMethods)
                .forEach(method -> {
                    System.out.println("Name: " + method.getName());
                    System.out.println("Return Type: " + method.getReturnType());
                    System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
                    System.out.println("-----------------------");
                });

        // Getting all constructors of the Card Class
        Constructor<?>[] cardConstructors = cardClass.getConstructors();

        System.out.println("Card Class' constructors: ");
        Arrays.stream(cardConstructors)
                .forEach(constructor -> {
                    System.out.println("Name: " + constructor.getName());
                    System.out.println("Parameter Types: " + Arrays.toString(constructor.getParameterTypes()));
                    System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
                    System.out.println("-----------------------");
                });

        // Creating an instance of CheckingAccount using reflection purely
        try {
            // Load CheckingAccount class via reflection
            Class<?> checkingAccountClass = Class.forName("org.example.CheckingAccount");

            // Getting the constructor of CheckingAccount
            Constructor<?> constructor = checkingAccountClass.getConstructor(double.class, double.class);

            // New instance using constructor
            Object newChecking = constructor.newInstance(10000.0, 20000.0);

            // Casting newChecking to CheckingAccount
            CheckingAccount checkingAccount = (CheckingAccount) newChecking;
            System.out.println("checkingAccount's initial balance prior to changing it via reflection: " + checkingAccount.getBalance());

            // Getting the field for balance
            Field balanceField = checkingAccountClass.getDeclaredField("balance");

            // Enabling access to the protected balance field
            balanceField.setAccessible(true);

            // Setting a new value for the balance field
            double newBalance = 15000.0;
            balanceField.set(checkingAccount, newBalance);

            // Field.get returns an 'Object' so we need to cast the balance to print it to the console
            double updatedBalance = (double) balanceField.get(checkingAccount);
            System.out.println("Updated balance: " + updatedBalance);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
