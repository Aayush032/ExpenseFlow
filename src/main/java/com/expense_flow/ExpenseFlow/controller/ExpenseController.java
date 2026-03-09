package com.expense_flow.ExpenseFlow.controller;

import com.expense_flow.ExpenseFlow.dto.request.ExpenseCreateRequest;
import com.expense_flow.ExpenseFlow.dto.request.ExpenseItemCreateRequest;
import com.expense_flow.ExpenseFlow.dto.response.ServerResponse;
import com.expense_flow.ExpenseFlow.facade.ExpenseFacade;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
@Validated
public class ExpenseController {
    private final ExpenseFacade facade;

    @PostMapping("/add")
    public ResponseEntity<ServerResponse> create(@RequestBody @Valid ExpenseCreateRequest createRequest) {
        ServerResponse serverResponse = facade.create(createRequest);
        return new ResponseEntity<>(serverResponse, serverResponse.getStatus());
    }
}
