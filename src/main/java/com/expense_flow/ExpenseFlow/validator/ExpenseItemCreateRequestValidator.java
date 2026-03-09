package com.expense_flow.ExpenseFlow.validator;

import com.expense_flow.ExpenseFlow.dto.command.ExpenseItemCommand;
import com.expense_flow.ExpenseFlow.dto.request.ExpenseItemCreateRequest;
import com.expense_flow.ExpenseFlow.entity.ExpenseItem;
import com.expense_flow.ExpenseFlow.exception.RequestValidationException;
import com.expense_flow.ExpenseFlow.service.queryService.ExpenseItemQueryService;
import com.expense_flow.ExpenseFlow.util.DateTimeUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class ExpenseItemCreateRequestValidator {
    private final ExpenseItemQueryService itemQueryService;

    public ExpenseItemCommand validate(ExpenseItemCreateRequest createRequest) {
        Optional<ExpenseItem> expenseItem = itemQueryService.getByDate(DateTimeUtil.getFormattedDate(createRequest.getExpenseDate()));
        if(expenseItem.isPresent()) {
            throw new RequestValidationException("Expense Item for this month is already created.");
        }

        return ExpenseItemCommand.from(createRequest);
    }
}
