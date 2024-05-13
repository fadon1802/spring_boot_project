package com.example.project.controllers;

import com.example.project.dto.PersonDto;
import com.example.project.validation.errors.ValidationError;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {

    @PostMapping("/person")
    public ResponseEntity<PersonDto> postPerson(@RequestBody @Valid PersonDto person) {
        String id = UUID.randomUUID().toString();
        var newPerson = new PersonDto(id, person.getName());
        return ResponseEntity.ok().body(newPerson);
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseEntity<List<ValidationError>> handleBindException(BindException ex) {
        List<ValidationError> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationError(error.getField(), error.getDefaultMessage()));
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}