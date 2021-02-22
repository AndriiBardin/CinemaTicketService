package cinema.security;

import cinema.security.impl.PasswordValidationImpl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordValidationImpl.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidation {
    String field();
    String fieldRepeat();
    String message() default "Invalid Password";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
