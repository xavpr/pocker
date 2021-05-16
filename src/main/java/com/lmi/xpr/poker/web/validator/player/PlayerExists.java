package com.lmi.xpr.poker.web.validator.player;

import com.lmi.xpr.poker.web.validator.ValidationMessage;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = PlayerExistsValidator.class)
@Documented
public @interface PlayerExists {

    String message() default ValidationMessage.PLAYER_UNKNOWN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
