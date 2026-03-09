package com.expense_flow.ExpenseFlow.dto.command;

import com.expense_flow.ExpenseFlow.dto.request.ExpenseItemCreateRequest;
import com.expense_flow.ExpenseFlow.util.DateTimeUtil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExpenseItemCommand {
    private String name;
    private String description;
    private LocalDate expenseDate;
    private Double amount;

    public static ExpenseItemCommand from(ExpenseItemCreateRequest request) {
        ExpenseItemCommand command = new ExpenseItemCommand();
        command.setName(request.getTitle());
        command.setDescription(request.getDescription());
        command.setExpenseDate(DateTimeUtil.getFormattedDate(request.getExpenseDate()));
        command.setAmount(Double.valueOf(request.getAmount()));
        return command;
    }
}
