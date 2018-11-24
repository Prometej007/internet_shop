package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.PromoCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PromoCodeService extends GrudOperations<PromoCode> {

    PromoCode findByCode(String code);
    PromoCode findByCode(PromoCode promoCode);

    Page<PromoCode> findAll(Pageable pageable);

}
