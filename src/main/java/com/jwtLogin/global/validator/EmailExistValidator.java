package com.jwtLogin.global.validator;

import com.jwtLogin.app.service.MemberQueryService;
import com.jwtLogin.global.annotation.ExistEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailExistValidator implements ConstraintValidator<ExistEmail, String> {
    private final MemberQueryService memberQueryService;
    @Override
    public void initialize(ExistEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !memberQueryService.existByEmail(value);
    }
}
