package com.imhui.common.validator;

import com.imhui.common.annotation.IdentityCardNumber;
import com.imhui.common.util.IdCardValidatorUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentityCardNumberValidator implements ConstraintValidator<IdentityCardNumber,Object> {
    @Override
    public void initialize(IdentityCardNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return IdCardValidatorUtils.isValidate18Idcard(value.toString());
    }
}
