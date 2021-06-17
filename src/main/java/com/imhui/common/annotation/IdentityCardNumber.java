package com.imhui.common.annotation;

import com.imhui.common.validator.IdentityCardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardNumberValidator.class)
public @interface IdentityCardNumber {

    String message() default "{com.imhui.validation.constraints.IdentityCardNumber.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
