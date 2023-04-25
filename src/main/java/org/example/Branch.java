package org.example;
import java.util.Objects;

public final class  Branch {
    private static int nextBranchID;

    static {
        nextBranchID = 1;
    }
    private final int branchID;
    private final String branchName;
    private final String location;

    public Branch(String branchName, String location) {
        this.branchName = branchName;
        this.location = location;
        this.branchID = nextBranchID++;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getLocation() {
        return location;
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

