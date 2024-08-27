package smartbox.handling_request.validator.TransmissionDate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TransmissionDateValidator.class)
public  @interface ValidTransmissionDate {
    String message() default "Username is already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}