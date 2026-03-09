package com.expense_flow.ExpenseFlow.service;


import com.expense_flow.ExpenseFlow.dto.command.ExpenseCommand;
import com.expense_flow.ExpenseFlow.dto.constant.Status;
import com.expense_flow.ExpenseFlow.entity.Expense;
import com.expense_flow.ExpenseFlow.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public void add(ExpenseCommand command) {
        Expense expense = new Expense();
        expense.setName(command.getTitle());
        expense.setDescription(command.getDescription());
        expense.setAmount(command.getAmount());
        expense.setType(command.getExpenseType());
        expense.setStatus(Status.CREATED);
        expense.setExpenseItem(command.getExpenseItem());
        expenseRepository.save(expense);
    }
}
