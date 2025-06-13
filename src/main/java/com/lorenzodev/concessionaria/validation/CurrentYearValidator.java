package com.lorenzodev.concessionaria.validation;

import java.time.Year;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CurrentYearValidator implements ConstraintValidator<CurrentYear, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // @NotNull já cuida disso
        }
        return value <= Year.now().getValue();
    }
} 