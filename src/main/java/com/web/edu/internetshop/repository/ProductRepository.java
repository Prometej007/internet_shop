package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.model.Product;
import com.web.edu.internetshop.model.enums.SoftnessType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {



    @Query(value = "select * from " +
            " product p left join category c2 on p.category_id = c2.id " +
            " left join product_materials pm on p.id = pm.product_id left join materials m on m.id = pm.materials_id " +
            " left join product_softness_types ps on p.id = ps.product_id " +
            " where " +

            " (  ( -1 in :category ) or c2.id in :category ) " +

            " and (  ( -1 in :materials ) or m.id in :materials ) " +

            " and (  ( -1 in :softness ) or ps.softness_types in :softness ) " +

            " and (  ( -1 in :productType ) or p.product_type in :productType ) " +

            " and ( ( :winterSummerOption is null ) or p.winter_summer_option=:winterSummerOption )" +

            " and ( ( :minPrice is null ) or p.price>=:minPrice )" +
            " and ( ( :maxPrice is null ) or p.price<=:maxPrice )" +

            " and ( ( :minHeight is null ) or p.height>=:minHeight)" +
            " and ( ( :maxHeight is null ) or p.height<=:maxHeight)" +

            " and ( ( :minWidth is null ) or p.width>=:minWidth)" +
            " and ( ( :maxWidth is null ) or p.width<=:maxWidth)" +

            " and ( ( :minLength is null ) or p.length>=:minLength)" +
            " and ( ( :maxLength is null ) or p.length<=:maxLength)" +

            " and ( ( :minMaximumLoad is null ) or p.maximum_load>=:minMaximumLoad)" +
            " and ( ( :maxMaximumLoad is null ) or p.maximum_load<=:maxMaximumLoad)" +
            "",nativeQuery = true)
    List<Product> filter(
            @Param("category") List<Long> category,
            @Param("materials") List<Long> materials,
            @Param("softness") List<Integer> softness,
            @Param("productType") List<Integer> productType,
            @Param("winterSummerOption") Boolean winterSummerOption,

            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,

            @Param("minHeight") Double minHeight,
            @Param("maxHeight") Double maxHeight,

            @Param("minWidth") Double minWidth,
            @Param("maxWidth") Double maxWidth,

            @Param("minLength") Double minLength,
            @Param("maxLength") Double maxLength,

            @Param("minMaximumLoad") Double minMaximumLoad,
            @Param("maxMaximumLoad") Double maxMaximumLoad
            );


    @Query(value = "select * from " +
            " product p left join category c2 on p.category_id = c2.id " +
            " left join product_materials pm on p.id = pm.product_id left join materials m on m.id = pm.materials_id " +
            " left join product_softness_types ps on p.id = ps.product_id " +
            " where " +

            " (  ( -1 in :category ) or c2.id in :category ) " +

            " and (  ( -1 in :materials ) or m.id in :materials ) " +

            " and (  ( -1 in :softness ) or ps.softness_types in :softness ) " +

            " and (  ( -1 in :productType ) or p.product_type in :productType ) " +

            " and ( ( :winterSummerOption is null ) or p.winter_summer_option=:winterSummerOption )" +

            " and ( ( :minPrice is null ) or p.price>=:minPrice )" +
            " and ( ( :maxPrice is null ) or p.price<=:maxPrice )" +

            " and ( ( :minHeight is null ) or p.height>=:minHeight)" +
            " and ( ( :maxHeight is null ) or p.height<=:maxHeight)" +

            " and ( ( :minWidth is null ) or p.width>=:minWidth)" +
            " and ( ( :maxWidth is null ) or p.width<=:maxWidth)" +

            " and ( ( :minLength is null ) or p.length>=:minLength)" +
            " and ( ( :maxLength is null ) or p.length<=:maxLength)" +

            " and ( ( :minMaximumLoad is null ) or p.maximum_load>=:minMaximumLoad)" +
            " and ( ( :maxMaximumLoad is null ) or p.maximum_load<=:maxMaximumLoad)" +
            " group by p.id order by ?#{#pageable}"
            ,countQuery = "select count(*) from " +
            " product p left join category c2 on p.category_id = c2.id " +
            " left join product_materials pm on p.id = pm.product_id left join materials m on m.id = pm.materials_id " +
            " left join product_softness_types ps on p.id = ps.product_id " +
            " where " +

            " (  ( -1 in :category ) or c2.id in :category ) " +

            " and (  ( -1 in :materials ) or m.id in :materials ) " +

            " and (  ( -1 in :softness ) or ps.softness_types in :softness ) " +

            " and (  ( -1 in :productType ) or p.product_type in :productType ) " +

            " and ( ( :winterSummerOption is null ) or p.winter_summer_option=:winterSummerOption )" +

            " and ( ( :minPrice is null ) or p.price>=:minPrice )" +
            " and ( ( :maxPrice is null ) or p.price<=:maxPrice )" +

            " and ( ( :minHeight is null ) or p.height>=:minHeight)" +
            " and ( ( :maxHeight is null ) or p.height<=:maxHeight)" +

            " and ( ( :minWidth is null ) or p.width>=:minWidth)" +
            " and ( ( :maxWidth is null ) or p.width<=:maxWidth)" +

            " and ( ( :minLength is null ) or p.length>=:minLength)" +
            " and ( ( :maxLength is null ) or p.length<=:maxLength)" +

            " and ( ( :minMaximumLoad is null ) or p.maximum_load>=:minMaximumLoad)" +
            " and ( ( :maxMaximumLoad is null ) or p.maximum_load<=:maxMaximumLoad)" +
            " group by p.id order by ?#{#pageable}",nativeQuery = true)
    Page<Product> filter(
            @Param("category") List<Long> category,
            @Param("materials") List<Long> materials,
            @Param("softness") List<Integer> softness,
            @Param("productType") List<Integer> productType,
            @Param("winterSummerOption") Boolean winterSummerOption,

            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,

            @Param("minHeight") Double minHeight,
            @Param("maxHeight") Double maxHeight,

            @Param("minWidth") Double minWidth,
            @Param("maxWidth") Double maxWidth,

            @Param("minLength") Double minLength,
            @Param("maxLength") Double maxLength,

            @Param("minMaximumLoad") Double minMaximumLoad,
            @Param("maxMaximumLoad") Double maxMaximumLoad
    , Pageable  pageable
            );

}
