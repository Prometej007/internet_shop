package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.model.buy.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinRepository extends JpaRepository<Bin,Long> {

    Long countByPromoCode_Code(String promoCode_code);


}
