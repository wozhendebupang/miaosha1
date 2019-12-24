package com.zjy.validator;

import com.zjy.util.ValidatorUtil;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String>{


   private boolean required = false;

    public void initialize(IsMobile constainAnnotation){

        required = constainAnnotation.required();
    }

    public boolean isValid(String value, ConstraintValidatorContext context){
        if(required){
            return ValidatorUtil.isMobile(value);
        }else if(StringUtils.isEmpty(value)){
            return true;
        }else{
            return ValidatorUtil.isMobile(value);
        }
    }
}
