package com.expense_flow.ExpenseFlow.util.constraint;

import com.expense_flow.ExpenseFlow.util.DateTimeUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DateValidator implements ConstraintValidator<Date, String> {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(DateTimeUtil.DATE_FORMAT_STRICT)
                    .withResolverStyle(ResolverStyle.STRICT);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.isBlank()) {
            return true;
        }

        try {
            LocalDate.parse(value, FORMATTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
