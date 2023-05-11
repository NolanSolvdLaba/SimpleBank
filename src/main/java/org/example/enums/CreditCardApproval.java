package org.example.enums;

import org.example.CreditCard;

public enum CreditCardApproval {
    PENDING("Application is under review"),
    APPROVED("Application is approved"),
    REJECTED("Application is rejected");

    private final String approvalMessage;

    CreditCardApproval(String approvalMessage) {
        this.approvalMessage = approvalMessage;
    }

    public String getApprovalMessage() {
        return approvalMessage;
    }

    public static CreditCard processApplication(boolean isApproved, String cardNumber) {
        if (isApproved) {
            //create new credit card instance if approved
            //creditLimit set to zero
            System.out.println(CreditCardApproval.APPROVED);
            return new CreditCard(cardNumber, 0);
        } else if (CreditCardApproval.PENDING.equals(CreditCardApproval.PENDING)) {
            System.out.println(CreditCardApproval.PENDING);
        } else {
            System.out.println(CreditCardApproval.REJECTED);
        }
        return null;
    }
}
