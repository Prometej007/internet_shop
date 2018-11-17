package com.web.edu.internetshop.dto.validator.annotations;

import com.web.edu.internetshop.dto.validator.PromoCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PromoCodeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PromoCodeConstraint {
    String message() default "PromoCode error";
    boolean exist() default true;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}