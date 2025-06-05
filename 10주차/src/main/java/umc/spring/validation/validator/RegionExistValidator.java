package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.RegionRepository.RegionRepository;
import umc.spring.validation.annotation.ExistRegions;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegions, Long> {

    private final RegionRepository regionRepository;

    @Override
    public void initialize(ExistRegions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long regionId, ConstraintValidatorContext context) {

        boolean exist = regionRepository.existsById(regionId);

        if (!exist) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return exist;
    }
}
