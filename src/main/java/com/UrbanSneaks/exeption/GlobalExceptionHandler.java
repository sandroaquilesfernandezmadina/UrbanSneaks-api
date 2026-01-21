package com.UrbanSneaks.exeption;

import org.apache.catalina.loader.ResourceEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(
        ResourceNotFoundException ex) {

    Map<String, Object> error = new HashMap<>();
    error.put("status", 404);
    error.put("message", ex.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
}
}