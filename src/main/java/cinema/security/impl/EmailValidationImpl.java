package cinema.security.impl;

import cinema.security.EmailValidation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidationImpl
        implements ConstraintValidator<EmailValidation, String> {
    private static final String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(regex);
    }
}
