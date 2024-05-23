package com.example.project.validation.validators;

import com.example.project.validation.annotations.Name;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class NameUppercaseValidator implements ConstraintValidator<Name, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches("[A-Z][a-z]*", value);
    }
}
