package org.example;

import java.time.LocalDateTime;

public class Transaction  {
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(double amount) {
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction of " + amount + " made at " + timestamp;
    }
}

