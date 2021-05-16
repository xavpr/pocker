package com.lmi.xpr.poker.web.validator.deck;

import com.lmi.xpr.poker.domain.service.DeckService;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class DeckExistsValidator implements ConstraintValidator<DeckExists, Long> {

    private final DeckService service;

    @Override
    public void initialize(DeckExists constraintAnnotation) {
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
