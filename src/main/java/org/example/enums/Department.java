package org.example.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Department {
    IT("Information Technology"),
    HR("Human Resources"),
    MARKETING("Customer Service"),
    FINANCE("Financial Advising");

    private String departmentName;

    Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getAbbreviation() {
        String[] words = departmentName.split(" ");
        return Arrays.stream(words)
                .map(word -> String.valueOf(word.charAt(0)))
                .collect(Collectors.joining());
    }

}
