package com.nhs.springboot.incomeservice.annotation;

import com.nhs.springboot.incomeservice.constant.Frequency;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Custom Validator for checking validations of
 * amount with frequency.
 */
public class AmountCheckValidator implements ConstraintValidator<AmountCheck, Object> {

    private String frequency;
    private String amount;

    @Override
    public void initialize(AmountCheck constraintAnnotation) {
        this.frequency = constraintAnnotation.frequency();
        this.amount = constraintAnnotation.amount();
    }

    @Override
    public boolean isValid(Object objValue,
        ConstraintValidatorContext constraintValidatorContext) {

        Object frequencyValue = new BeanWrapperImpl(objValue)
            .getPropertyValue(frequency);
        Object amountValue = new BeanWrapperImpl(objValue)
            .getPropertyValue(amount);

        if (Objects.nonNull(frequencyValue) && Objects.nonNull(amountValue)) {
            try{
                Double amount = Double.parseDouble(amountValue.toString());
                Integer inWeeks = Frequency.valueOf(frequencyValue.toString().toUpperCase()).getValue();
                Double wholeNumAmount = amount / inWeeks;

                if ((inWeeks != 1) && ((wholeNumAmount - Math.floor(wholeNumAmount)) != 0)) {
                    //Amount divided by weeks is not a whole number - Validation Error
                    return false;
                }
            } catch (NumberFormatException nfe) {
                return true;
            }
        }
        return true;
    }

}
