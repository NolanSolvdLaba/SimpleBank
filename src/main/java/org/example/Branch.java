package org.example;
/* Branch class
two private fields: branchName, location
 */

public class Branch {
    private String branchName;
    private String location;

    public Branch(String branchName, String location) {
        this.branchName = branchName;
        this.location = location;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

