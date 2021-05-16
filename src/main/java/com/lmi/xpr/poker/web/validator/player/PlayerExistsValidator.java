package com.lmi.xpr.poker.web.validator.player;

import com.lmi.xpr.poker.domain.service.PlayerService;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class PlayerExistsValidator implements ConstraintValidator<PlayerExists, Long> {

    private final PlayerService service;

    @Override
    public void initialize(PlayerExists constraintAnnotation) {
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
