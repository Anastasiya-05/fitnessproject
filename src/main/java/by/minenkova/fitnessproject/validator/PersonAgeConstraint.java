package by.minenkova.fitnessproject.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PersonAgeConstraintValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonAgeConstraint {
    String message() default "{Age}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
