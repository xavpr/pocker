package com.lmi.xpr.poker.web.validator.game;

import com.lmi.xpr.poker.web.validator.ValidationMessage;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = GameExistsValidator.class)
@Documented
public @interface GameExists {

    String message() default ValidationMessage.GAME_UNKNOWN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
