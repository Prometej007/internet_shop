package com.web.edu.internetshop.controller;

import com.web.edu.internetshop.dto.model.ProductFullDto;
import com.web.edu.internetshop.dto.model.ProductShortDto;
import com.web.edu.internetshop.dto.model.request.ProductAddRequestDTO;
import com.web.edu.internetshop.dto.utils.builder.Builder;
import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@RestController( "/product" )
public class ProductController {

    private final ProductService productService;

    public ProductController( final ProductService aProductService ) {
        productService = aProductService;
    }

    @PostMapping( "/save-product" )
    public ResponseEntity<HttpStatus> saveProduct( @RequestBody ProductAddRequestDTO request ) {
        productService.create( Builder.map( request, Product.class ) );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @PostMapping( "/update-availability" )
    public ResponseEntity<HttpStatus> updateAvailability( @RequestParam Long productId,
                                                          @RequestParam Boolean available ) {
        productService.setAvailability( productId, available );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @GetMapping( "/find-product" )
    public ResponseEntity<ProductFullDto> retrieveProduct( @RequestParam Long productId ) {
        final ProductFullDto product = Builder.map( productService.findOne( productId ), ProductFullDto.class );
        return new ResponseEntity<>( product, HttpStatus.OK );
    }

    @GetMapping( "/find-products" )
    public ResponseEntity<List<ProductShortDto>> retrieveProducts( @RequestParam List<Long> category,
                                                                   @RequestParam List<Long> materials,
                                                                   @RequestParam List<Integer> softness,
                                                                   @RequestParam List<Integer> productType,
                                                                   @RequestParam Boolean winterSummerOption,
                                                                   @RequestParam BigDecimal minPrice,
                                                                   @RequestParam BigDecimal maxPrice,
                                                                   @RequestParam Double minHeight,
                                                                   @RequestParam Double maxHeight,
                                                                   @RequestParam Double minWidth,
                                                                   @RequestParam Double maxWidth,
                                                                   @RequestParam Double minLength,
                                                                   @RequestParam Double maxLength,
                                                                   @RequestParam Double minMaximumLoad,
                                                                   @RequestParam Double maxMaximumLoad,
                                                                   @NotNull final Pageable pageable ) {

        final List<Product> products = productService.findProductsByPageable( category,
                                                                              materials,
                                                                              softness,
                                                                              productType,
                                                                              winterSummerOption,
                                                                              minPrice,
                                                                              maxPrice,
                                                                              minHeight,
                                                                              maxHeight,
                                                                              minWidth,
                                                                              maxWidth,
                                                                              minLength,
                                                                              maxLength,
                                                                              minMaximumLoad,
                                                                              maxMaximumLoad,
                                                                              pageable );
        return new ResponseEntity<>( Builder.map( products, ProductShortDto.class ), HttpStatus.OK );
    }
}
