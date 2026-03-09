package com.expense_flow.ExpenseFlow.dto.request;

import com.expense_flow.ExpenseFlow.util.constraint.ExpenseType;
import com.expense_flow.ExpenseFlow.util.constraint.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseCreateRequest {
    @NotBlank(message = "Name is required.")
    @Size(min = 1, max = 100, message = "Name must be within 100 characters.")
    private String title;

    @Size(max = 255, message = "Description must be within 255 characters.")
    private String description;

    @NotBlank(message = "Amount is required.")
    @Pattern(
            regexp = "^(?!0+(\\.0{1,2})?$)\\d+(\\.\\d{1,2})?$",
            message = "Amount must be greater than 0 and allow up to 2 decimal places."
    )
    private String amount;

    @ExpenseType
    private String expenseType;

    @Id(field = "Expense Item")
    private Short expenseItem;
}
