package com.nhs.springboot.incomeservice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Custom Annotation for Checking
 * Amount with Frequency
 */
@Constraint(validatedBy = AmountCheckValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AmountCheck {

    String message();

    String frequency();

    String amount();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
