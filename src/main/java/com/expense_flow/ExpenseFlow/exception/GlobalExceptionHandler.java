package com.expense_flow.ExpenseFlow.exception;

import com.expense_flow.ExpenseFlow.dto.response.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<ServerResponse> handleRequestValidationException(RequestValidationException ex) {
        ServerResponse serverResponse = ServerResponse.failureResponse(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(serverResponse, serverResponse.getStatus());
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<ServerResponse> handleBadRequestException(HttpClientErrorException.BadRequest ex) {
        ServerResponse serverResponse = ServerResponse.failureResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(serverResponse, serverResponse.getStatus());
    }
}
