package org.example;

import org.example.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;

import org.example.exceptions.InsufficientFundsException;
class SavingsAccountTest {

    @Test
    public void testWithdrawNegativeAmount() {
        SavingsAccount account = new SavingsAccount(2000.0, .2, "Canadian Dollars", true, "Donny Dollars");
        //trying to withdraw a negative amount
        assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(-100.0);
        });
    }

    @Test public void testWithdrawExceedsBalance() {
        SavingsAccount account = new SavingsAccount(1000.0, .2, "Canadian Dollars", true, "Donny Dollars");
        //trying to withdraw
        assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(1500.0);
        });
    }
}