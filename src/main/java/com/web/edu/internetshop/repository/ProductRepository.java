package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query(value = "select * from " +
            " product p join category c2 on p.category_id = c2.id " +
            " join product_materials pm on p.id = pm.product_id " +
            " join product_softness ps on p.id = ps.product_id " +
            " where " +
            " (  ( -1 in :category ) or c2.id in :category ) " +
            "",nativeQuery = true)
    List<Product> filter(@Param("category") List<Long> category);


}
