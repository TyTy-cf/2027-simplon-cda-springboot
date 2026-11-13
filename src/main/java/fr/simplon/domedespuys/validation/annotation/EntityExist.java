package fr.simplon.domedespuys.validation.annotation;

import fr.simplon.domedespuys.service.interfaces.dao.IGetItem;
import fr.simplon.domedespuys.validation.EntityExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EntityExistValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EntityExist {

    Class<? extends IGetItem<?>> serviceImpl();

    String message() default "Donnée incorrecte";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
