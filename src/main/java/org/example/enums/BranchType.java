package org.example.enums;

public enum BranchType {
    KIOSK("Kiosk"),
    RETAIL_BRANCH("Retail Branch"),
    BUSINESS_BRANCH("Business Branch");

    private final String branchType;

    BranchType(String branchType){
        this.branchType = branchType;
    }

    public String getTypeName(){
        return branchType;
    }
}
