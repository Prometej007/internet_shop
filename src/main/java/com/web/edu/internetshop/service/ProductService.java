package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService extends GrudOperations<Product> {

    Page<Product> findProductsByPageable( final List<Long> category,
                                          final List<Long> materials,
                                          final List<Integer> softness,
                                          final List<Integer> productType,
                                          final Boolean winterSummerOption,
                                          final BigDecimal minPrice,
                                          final BigDecimal maxPrice,
                                          final Double minHeight,
                                          final Double maxHeight,
                                          final Double minWidth,
                                          final Double maxWidth,
                                          final Double minLength,
                                          final Double maxLength,
                                          final Double minMaximumLoad,
                                          final Double maxMaximumLoad,
                                          final Pageable pageable );
    
    Boolean setAvailability( Long productId, boolean available );
    Boolean unlockBuy(Product product);
    Boolean lockBuy(Product product);

    Page<Product> findAll(Pageable pageable);

}
