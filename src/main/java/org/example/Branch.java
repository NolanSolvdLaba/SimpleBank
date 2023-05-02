package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Branch {
    private static int nextBranchID;

    static {
        nextBranchID = 1;
    }

    private final int branchID;
    private final String branchName;
    private final String location;
    private final List<Employee> employees;

    public Branch(String branchName, String location) {
        this.branchName = branchName;
        this.location = location;
        this.branchID = nextBranchID++;
        this.employees = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public String getLocation() {
        return location;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> searchEmployeesByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> searchEmployeesBySalary(double salary) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() == salary) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> searchEmployeesByDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchName, branch.branchName) && Objects.equals(location, branch.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchName, location);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchName='" + branchName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
