package org.example;
/* CreditReport class
3 private fields: creditScore, numLatePayments
Methods: getters and setters for fields
 */


public class CreditReport {
    private int creditScore;
    private int numLatePayments;
    private int numAccounts;

    public CreditReport(int creditScore, int numLatePayments, int numAccounts) {
        this.creditScore = creditScore;
        this.numLatePayments = numLatePayments;
        this.numAccounts = numAccounts;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getNumLatePayments() {
        return numLatePayments;
    }

    public void setNumLatePayments(int numLatePayments) {
        this.numLatePayments = numLatePayments;
    }

    public int getNumAccounts() {
        return numAccounts;
    }

    public void setNumAccounts(int numAccounts) {
        this.numAccounts = numAccounts;
    }
}
