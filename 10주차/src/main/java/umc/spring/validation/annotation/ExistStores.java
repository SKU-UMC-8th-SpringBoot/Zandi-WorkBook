package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {StoreExistValidator.class})
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStores {

    String message() default "해당하는 가게가 존재하지않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
