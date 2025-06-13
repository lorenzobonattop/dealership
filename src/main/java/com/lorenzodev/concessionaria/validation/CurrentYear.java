package com.lorenzodev.concessionaria.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CurrentYearValidator.class)
public @interface CurrentYear {
    String message() default "O ano não pode ser maior que o atual";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 