package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MemberExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {MemberExistValidator.class})
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {

    String message() default "해당하는 멤버가 존재하지않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
