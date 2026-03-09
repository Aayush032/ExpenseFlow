package com.expense_flow.ExpenseFlow.repository;

import com.expense_flow.ExpenseFlow.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
