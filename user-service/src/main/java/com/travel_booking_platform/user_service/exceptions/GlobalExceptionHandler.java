package com.travel_booking_platform.user_service.exceptions;

import com.travel_booking_platform.user_service.entities.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler
    public ResponseEntity<String> handleUserNotFoundException(LocalDate timestamp, UserNotFoundException e, WebRequest request){
        Map<Object, Object> exceptionResponse = new HashMap<>();
        exceptionResponse.put("timestamp", timestamp);
        exceptionResponse.put("message", e.getMessage());
        exceptionResponse.put("details", request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse.toString());
    }
}
