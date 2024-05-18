package com.example.project.controller;

import com.example.project.aspect.APIMethod;
import com.example.project.error.RequestsLimitException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class Controller {

    @APIMethod
    @GetMapping("/aspects")
    public ResponseEntity<String> limitedApi() {
        return ResponseEntity.ok().body("okay");
    }

    @ExceptionHandler(RequestsLimitException.class)
    public ResponseEntity<String> handleRequestLimitExceededException(RequestsLimitException ex) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(ex.getMessage());
    }

}
