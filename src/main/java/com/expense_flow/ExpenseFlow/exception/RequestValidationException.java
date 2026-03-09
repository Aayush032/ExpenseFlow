package com.expense_flow.ExpenseFlow.exception;

public class RequestValidationException extends RuntimeException{
    public RequestValidationException(String message) {
        super(message);
    }
}
