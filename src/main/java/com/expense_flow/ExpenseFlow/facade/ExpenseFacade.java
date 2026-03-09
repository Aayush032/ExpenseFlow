package com.expense_flow.ExpenseFlow.facade;

import com.expense_flow.ExpenseFlow.dto.command.ExpenseCommand;
import com.expense_flow.ExpenseFlow.dto.request.ExpenseCreateRequest;
import com.expense_flow.ExpenseFlow.dto.response.ServerResponse;
import com.expense_flow.ExpenseFlow.service.ExpenseService;
import com.expense_flow.ExpenseFlow.validator.ExpenseCreateRequestValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExpenseFacade {
    private final ExpenseCreateRequestValidator createRequestValidator;
    private final ExpenseService expenseService;

    public ServerResponse create(ExpenseCreateRequest request) {
        ExpenseCommand command = createRequestValidator.validate(request);
        expenseService.add(command);
        return ServerResponse.successResponse("Expense added successfully.", null, HttpStatus.OK);
    }
}
