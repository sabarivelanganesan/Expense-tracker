package com.finqube.expense_service.exception;

public class ExpenseIDNotFoundException extends RuntimeException {
    public ExpenseIDNotFoundException(String message) {
        super(message);
    }
}
