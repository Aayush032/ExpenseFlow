package com.expense_flow.ExpenseFlow.dto.command;

import com.expense_flow.ExpenseFlow.dto.constant.ExpenseType;
import com.expense_flow.ExpenseFlow.dto.request.ExpenseCreateRequest;
import com.expense_flow.ExpenseFlow.entity.ExpenseItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseCommand {
    private String title;
    private String description;
    private Double amount;
    private ExpenseType expenseType;
    private ExpenseItem expenseItem;

    public static ExpenseCommand of(ExpenseCreateRequest request, ExpenseItem expenseItem) {
        ExpenseCommand command = new ExpenseCommand();
        command.setTitle(request.getTitle());
        command.setDescription(request.getDescription());
        command.setExpenseType(ExpenseType.valueOf(request.getExpenseType()));
        command.setAmount(Double.valueOf(request.getAmount()));
        command.setExpenseItem(expenseItem);
        return command;
    }
}
