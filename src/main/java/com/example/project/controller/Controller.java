package com.example.project.controller;

import com.example.project.aspect.APIMethod;
import com.example.project.dto.Response;
import com.example.project.error.RequestsLimitException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class Controller {

    @APIMethod
    @GetMapping("/aspects")
    public Response limitedApi() {
        return new Response("okay");
    }

    @ExceptionHandler(RequestsLimitException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public Response handleRequestLimitExceededException(RequestsLimitException ex) {
        return new Response(ex.getMessage());
    }

}
