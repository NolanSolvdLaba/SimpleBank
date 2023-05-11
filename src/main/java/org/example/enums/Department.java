package org.example.enums;

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
        StringBuilder abbreviation = new StringBuilder();
        for (String word : words) {
            abbreviation.append(word.charAt(0));
        }
        return abbreviation.toString();
    }
}
