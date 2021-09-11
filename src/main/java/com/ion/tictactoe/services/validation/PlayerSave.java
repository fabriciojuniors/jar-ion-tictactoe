package com.ion.tictactoe.services.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PlayerSaveValidator.class)
public @interface PlayerSave {
    String message() default "Erro ao validar registro.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
