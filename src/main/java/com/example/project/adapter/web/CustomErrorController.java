package com.example.project.adapter.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomErrorController implements ErrorController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseEntity<Object> handleException(Exception ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(502, "Ошибка 502", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);
    }

    @Getter
    @Setter
    private static class CustomErrorResponse {
        private int status;
        private String message;
        private String error;

        public CustomErrorResponse(int status, String message, String error) {
            this.status = status;
            this.message = message;
            this.error = error;
        }
    }
}