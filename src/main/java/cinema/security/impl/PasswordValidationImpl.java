package cinema.security.impl;

import cinema.dto.UserRequestDto;
import cinema.security.PasswordValidation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidationImpl
        implements ConstraintValidator<PasswordValidation, UserRequestDto> {
    private String password;
    private String repeatPassword;

    @Override
    public void initialize(PasswordValidation passwordValidation) {
        this.password = passwordValidation.field();
        this.repeatPassword = passwordValidation.fieldRepeat();
    }

    @Override
    public boolean isValid(UserRequestDto userRequestDto,
                           ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(userRequestDto)
                .getPropertyValue(password);
        Object fieldMatchValue = new BeanWrapperImpl(userRequestDto)
                .getPropertyValue(repeatPassword);

        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        }
        return fieldMatchValue == null;
    }
}
