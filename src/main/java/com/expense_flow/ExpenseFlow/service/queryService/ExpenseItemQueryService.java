package com.expense_flow.ExpenseFlow.service.queryService;


import com.expense_flow.ExpenseFlow.entity.ExpenseItem;
import com.expense_flow.ExpenseFlow.repository.ExpenseItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ExpenseItemQueryService {
    private final ExpenseItemRepository itemRepository;

    public Optional<ExpenseItem> getByDate(LocalDate date) {
        return itemRepository.getByDate(date);
    }

    public Optional<ExpenseItem> getById(Short id) {
        return itemRepository.getItemById(id);
    }
}

