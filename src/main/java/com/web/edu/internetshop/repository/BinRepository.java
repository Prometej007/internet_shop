package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.model.buy.Bin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BinRepository extends JpaRepository<Bin, Long> {

    Long countByPromoCode_Code(String promoCode_code);

    Integer countByOrder(String order);

    @Query(value = "select * from bin b join bin_status bs on b.id = bs.bin_id " +
            " where bs.type=:binstatus and b.id not in(" +
            " select bv.id from bin bv join bin_status s on bv.id = s.bin_id " +
            "  where s.type>:binstatus" +
            ")", nativeQuery = true)
    List<Bin> adminFilter(@Param("binstatus") Integer binStatus);

    @Query(value = "select * from bin b join bin_status bs on b.id = bs.bin_id " +
            " where bs.type=:binstatus and b.id not in(" +
            " select bv.id from bin bv join bin_status s on bv.id = s.bin_id " +
            "  where s.type>:binstatus" +
            ") group by b.id order by ?#{#pageable}",
            countQuery = "select count(*) from bin b join bin_status bs on b.id = bs.bin_id " +
                    " where bs.type=:binstatus and b.id not in(" +
                    " select bv.id from bin bv join bin_status s on bv.id = s.bin_id " +
                    "  where s.type>:binstatus" +
                    ") group by b.id order by ?#{#pageable}", nativeQuery = true)
    Page<Bin> adminFilter(@Param("binstatus") Integer binStatus, Pageable pageable);

}
