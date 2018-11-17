package com.web.edu.internetshop.dto.validator;

import com.web.edu.internetshop.dto.validator.annotations.PromoCodeConstraint;
import com.web.edu.internetshop.service.PromoCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Optional.ofNullable;

public class PromoCodeValidator implements
        ConstraintValidator<PromoCodeConstraint, String> {


    PromoCodeConstraint promoCodeConstraint;
    @Autowired
    private PromoCodeService promoCodeService;

    @Override
    public void initialize(PromoCodeConstraint promoCodeConstraint) {
        this.promoCodeConstraint = promoCodeConstraint;
    }

    @Override
    public boolean isValid(String promoCodeConstraint,
                           ConstraintValidatorContext cxt) {
        if (!this.promoCodeConstraint.exist()) {
            return promoCodeConstraint != null && ofNullable(promoCodeService.findByCode(promoCodeConstraint)).isPresent();
        } else {
            return promoCodeConstraint != null && !ofNullable(promoCodeService.findByCode(promoCodeConstraint)).isPresent();

        }
    }

}