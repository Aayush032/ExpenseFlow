package com.expense_flow.ExpenseFlow.validator;

import com.expense_flow.ExpenseFlow.dto.command.ExpenseCommand;
import com.expense_flow.ExpenseFlow.dto.request.ExpenseCreateRequest;
import com.expense_flow.ExpenseFlow.entity.ExpenseItem;
import com.expense_flow.ExpenseFlow.exception.RequestValidationException;
import com.expense_flow.ExpenseFlow.service.queryService.ExpenseItemQueryService;
import com.expense_flow.ExpenseFlow.service.queryService.ExpenseQueryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ExpenseCreateRequestValidator {
    private final ExpenseQueryService expenseQueryService;
    private final ExpenseItemQueryService expenseItemQueryService;

    public ExpenseCommand validate(ExpenseCreateRequest request) {
        ExpenseItem expenseItem = expenseItemQueryService.getById(request.getExpenseItem())
                .orElseThrow(() -> new RequestValidationException("Expense Item not found."));

        return ExpenseCommand.of(request, expenseItem);
    }
}
