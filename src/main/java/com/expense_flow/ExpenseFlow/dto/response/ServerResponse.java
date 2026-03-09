package com.expense_flow.ExpenseFlow.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ServerResponse<T> {
    private String message;
    private T data;
    private boolean success;
    private HttpStatus status;
    private int code;

    public static <T> ServerResponse<T> successResponse(String message, T data, HttpStatus status) {
        return ServerResponse.<T>builder()
                .message(message)
                .data(data)
                .success(true)
                .status(status)
                .code(status.value())
                .build();
    }

    public static <T> ServerResponse<T> failureResponse(String message, HttpStatus status) {
        return ServerResponse.<T>builder()
                .message(message)
                .data(null)
                .success(false)
                .status(status)
                .code(status.value())
                .build();
    }
}
