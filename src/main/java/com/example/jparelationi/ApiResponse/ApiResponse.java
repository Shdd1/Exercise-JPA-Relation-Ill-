package com.example.jparelationi.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
}
