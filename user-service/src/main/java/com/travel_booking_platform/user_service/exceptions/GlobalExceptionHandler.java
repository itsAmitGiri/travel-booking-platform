package com.travel_booking_platform.user_service.exceptions;

import com.travel_booking_platform.user_service.dto.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleUserNotFoundException(Exception e, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDetails(Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                        e.getMessage(), request.getDescription(false)));
    }
}
