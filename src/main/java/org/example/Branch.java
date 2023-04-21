package org.example;
import java.util.Objects;

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

