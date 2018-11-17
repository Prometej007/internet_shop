package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.PromoCode;

public interface PromoCodeService extends GrudOperations<PromoCode> {

    PromoCode findByCode(String code);
    PromoCode findByCode(PromoCode promoCode);

}
