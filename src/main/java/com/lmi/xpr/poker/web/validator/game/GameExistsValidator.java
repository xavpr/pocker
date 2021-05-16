package com.lmi.xpr.poker.web.validator.game;

import com.lmi.xpr.poker.domain.service.GameService;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class GameExistsValidator implements ConstraintValidator<GameExists, Long> {

    private final GameService service;

    @Override
    public void initialize(GameExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long idGame, ConstraintValidatorContext context) {

        boolean isValid = service.existsById(idGame);
        if (!isValid) {
            String messageTemplate = context.getDefaultConstraintMessageTemplate();
            context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation();
        }

        return  isValid;
    }
}
