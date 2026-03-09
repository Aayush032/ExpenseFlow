package com.expense_flow.ExpenseFlow.util.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ExpenseTypeValidator implements ConstraintValidator<ExpenseType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.isBlank()) {
            return false;
        }

        try {
            return Arrays.stream(com.expense_flow.ExpenseFlow.dto.constant.ExpenseType.values())
                    .anyMatch(type -> type.name().equals(value));
        } catch (Exception e) {
            return false;
        }
    }
}
