package org.example;

import org.example.exceptions.LoanAmountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

//testing the Loan Amount Exception
public class LoanAmountExceptionTest {
    @Test
    public void testInstantiateNegativeLoanAmount() {
        //attempting to instantiate Loan class with a negative loan amount
        assertThrows(LoanAmountException.class, () -> {
            Loan obamaDollars = new Loan(-100_000, .20, 60);
        });
    }

}
