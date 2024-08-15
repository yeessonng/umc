package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.District;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.validation.annotation.ExistDistrict;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DistrictExistValidator implements ConstraintValidator<ExistDistrict, Long> {

    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistDistrict constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long s, ConstraintValidatorContext constraintValidatorContext) {
        Optional<District> target = storeQueryService.findDistrict(s);

        if(target.isEmpty())
        {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.DISTRICT_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}
