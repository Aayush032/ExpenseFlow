package com.expense_flow.ExpenseFlow.util.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExpenseTypeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExpenseType {
    String message() default "Invalid expense type.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
