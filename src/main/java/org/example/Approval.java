package org.example;

public class Approval {
    private Customer customer;
    private int creditRating;

    public Approval(Customer customer, int creditRating) {
        this.customer = customer;
        this.creditRating = creditRating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }
}

