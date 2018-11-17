package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.model.PromoCode;
import com.web.edu.internetshop.model.buy.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode,Long> {
PromoCode findByCode(String code);
}
