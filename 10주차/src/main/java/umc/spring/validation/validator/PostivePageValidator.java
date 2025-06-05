package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.validation.annotation.PostivePage;

public class PostivePageValidator implements ConstraintValidator<PostivePage, Integer> {

    @Override
    public void initialize(PostivePage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if (value == null){
            return true;
        }
        return value >= 1;
    }
}
