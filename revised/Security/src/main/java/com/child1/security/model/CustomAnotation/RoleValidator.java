package com.child1.security.model.CustomAnotation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class RoleValidator implements ConstraintValidator<ValidRole, String> {

    private static final Set<String> ALLOWED =
            Set.of("USER", "ADMIN", "MANAGER");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) return false;

        return ALLOWED.contains(value.toUpperCase());
    }
}