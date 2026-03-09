package com.expense_flow.ExpenseFlow.service;

import com.expense_flow.ExpenseFlow.dto.command.ExpenseItemCommand;
import com.expense_flow.ExpenseFlow.dto.constant.Status;
import com.expense_flow.ExpenseFlow.entity.ExpenseItem;
import com.expense_flow.ExpenseFlow.repository.ExpenseItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseItemService {
    private final ExpenseItemRepository itemRepository;

    public void add(ExpenseItemCommand command) {
        ExpenseItem item = new ExpenseItem();
        item.setName(command.getName());
        item.setDescription(command.getDescription());
        item.setExpenseDate(command.getExpenseDate());
        item.setInitialAmount(command.getAmount());
        item.setStatus(Status.CREATED);
        itemRepository.save(item);
    }
}
