package com.expense_flow.ExpenseFlow.facade;

import com.expense_flow.ExpenseFlow.dto.command.ExpenseItemCommand;
import com.expense_flow.ExpenseFlow.dto.request.ExpenseItemCreateRequest;
import com.expense_flow.ExpenseFlow.dto.response.ServerResponse;
import com.expense_flow.ExpenseFlow.service.ExpenseItemService;
import com.expense_flow.ExpenseFlow.validator.ExpenseItemCreateRequestValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExpenseItemFacade {
    private final ExpenseItemCreateRequestValidator createRequestValidator;
    private final ExpenseItemService itemService;

    public ServerResponse create(ExpenseItemCreateRequest request) {
        ExpenseItemCommand command = createRequestValidator.validate(request);
        itemService.add(command);
        return ServerResponse.successResponse("Expense Item added successfully", null, HttpStatus.OK);
    }
}
