package com.lmi.xpr.poker.web.validator.deck;

import com.lmi.xpr.poker.web.validator.ValidationMessage;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = DeckExistsValidator.class)
@Documented
public @interface DeckExists {

    String message() default ValidationMessage.DECK_UNKNOWN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
