package com.expense_flow.ExpenseFlow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class MasterEntityBase implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }
}
