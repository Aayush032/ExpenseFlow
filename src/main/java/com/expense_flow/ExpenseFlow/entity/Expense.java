package com.expense_flow.ExpenseFlow.entity;

import com.expense_flow.ExpenseFlow.dto.constant.ExpenseType;
import com.expense_flow.ExpenseFlow.dto.constant.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "EXPENSE")
@Getter
@Setter
public class Expense extends TransactionalEntityBase{
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ExpenseType type;

    @Column(name = "MODIFIED_DATE", nullable = true)
    private LocalDateTime modifiedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "EXPENSE_TRACKER", referencedColumnName = "ID", nullable = false)
    private ExpenseItem expenseItem;
}
