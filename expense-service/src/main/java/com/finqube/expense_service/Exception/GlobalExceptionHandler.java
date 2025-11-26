//package com.finqube.expense_service.exception;
//
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(InvalidFormatException.class)
//    public ResponseEntity<?> handleInvalidFormat(InvalidFormatException exception) {
//        String fieldName = exception.getPath().get(0).getFieldName();
//        String targetType = exception.getTargetType().getSimpleName();
//        String msg = "Invalid value for field '" + fieldName + "'. Expected type: " + targetType;
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
//    }
//}
