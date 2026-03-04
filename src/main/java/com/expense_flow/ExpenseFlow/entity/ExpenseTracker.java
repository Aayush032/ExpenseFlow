package com.expense_flow.ExpenseFlow.entity;

import com.expense_flow.ExpenseFlow.dto.constant.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "EXPENSE_TRACKER")
@Getter
@Setter
public class ExpenseTracker extends MasterEntityBase{
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @Column(name = "EXPENSE_DATE", nullable = false)
    private LocalDate expenseDate;

    @Column(name = "INITIAL_AMOUNT", nullable = false)
    private Double initialAmount;

    @Column(name = "MODIFIED_DATE", nullable = true)
    private LocalDateTime modifiedDate;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "USER", referencedColumnName = "ID", nullable = false)
    private User user;
}
