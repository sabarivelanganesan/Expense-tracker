package com.finqube.expense_service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ExpenseIDNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleExpenseNotFoundByID(ExpenseIDNotFoundException exception) {
        Map<String, String> error = new HashMap<>();
        log.warn("Expense not Found");
        error.put("message", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleExpenseNotFound(ExpenseNotFoundException exception) {
        Map<String, String> error = new HashMap<>();
        log.warn("There are no expense created yet");
        error.put("message", exception.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidJson(HttpMessageNotReadableException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Invalid JSON format. Please check your request body.");
        return ResponseEntity.badRequest().body(error);
    }


}
