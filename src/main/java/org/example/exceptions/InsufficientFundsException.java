package org.example.exceptions;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Withdrawal failed due to insufficient funds.");
    }
}

