package com.example.project.validation.annotations;

import com.example.project.validation.validators.NameUppercaseValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameUppercaseValidator.class)
@Size(min = 2, max = 15, message = "{name.validator.size.not_valid}")
public @interface Name {
    String message() default "{name.validator.not_valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
