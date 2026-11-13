package fr.simplon.domedespuys.validation;

import fr.simplon.domedespuys.service.interfaces.dao.IGetItem;
import fr.simplon.domedespuys.validation.annotation.EntityExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityExistValidator implements ConstraintValidator<EntityExist, String> {

    private IGetItem<?> service;

    private final BeanFactory beans;

    @Autowired
    EntityExistValidator(BeanFactory beans) {
        this.beans = beans;
    }

    @Override
    public void initialize(EntityExist constraintAnnotation) {
        this.service = beans.getBean(constraintAnnotation.serviceImpl());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        return service.getById(value) != null;
    }

}
