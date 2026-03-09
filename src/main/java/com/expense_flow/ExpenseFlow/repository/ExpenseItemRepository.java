package com.expense_flow.ExpenseFlow.repository;

import com.expense_flow.ExpenseFlow.entity.ExpenseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ExpenseItemRepository extends JpaRepository<ExpenseItem, Short> {

    @Query("SELECT ei FROM ExpenseItem ei WHERE ei.expenseDate = :date AND ei.status != 'DELETED'")
    Optional<ExpenseItem> getByDate(@Param("date")LocalDate date);

    @Query("SELECT ei FROM ExpenseItem ei WHERE ei.id = :id AND ei.status != 'DELETED'")
    Optional<ExpenseItem> getItemById(@Param("id") Short id);
}
