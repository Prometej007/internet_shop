package com.web.edu.internetshop.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.edu.internetshop.dto.model.ProductFullDto;
import com.web.edu.internetshop.dto.model.ProductShortDto;
import com.web.edu.internetshop.dto.model.request.ProductAddRequestDTO;
import com.web.edu.internetshop.dto.utils.builder.Builder;
import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

import static com.web.edu.internetshop.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService aProductService) {
        productService = aProductService;
    }

    @PostMapping("/save-product")
    public ResponseEntity<HttpStatus> saveProduct( @Valid @RequestBody ProductAddRequestDTO request) {
        productService.create(map(request, Product.class));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update-availability")
    public ResponseEntity<HttpStatus> updateAvailability(@RequestParam Long productId,
                                                         @RequestParam Boolean available) {
        productService.setAvailability(productId, available);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-product")
    public ResponseEntity<ProductFullDto> retrieveProduct(@RequestParam Long productId) {
        final ProductFullDto product = map(productService.findOne(productId), ProductFullDto.class);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/find-products-filter")
    public ResponseEntity<Page<ProductFullDto>> retrieveProducts(@RequestParam(required = false,defaultValue = "-1") List<Long> category,
                                                                  @RequestParam(required = false,defaultValue = "-1") List<Long> materials,
                                                                  @RequestParam(required = false,defaultValue = "-1") List<Integer> softness,
                                                                  @RequestParam(required = false,defaultValue = "-1") List<Integer> productType,
                                                                  @RequestParam(required = false) Boolean winterSummerOption,
                                                                 @JsonFormat(shape = JsonFormat.Shape.STRING)
                                                                     @RequestParam(required = false) BigDecimal minPrice,
                                                                 @JsonFormat(shape = JsonFormat.Shape.STRING)
                                                                  @RequestParam(required = false) BigDecimal maxPrice,
                                                                  @RequestParam(required = false) Double minHeight,
                                                                  @RequestParam(required = false) Double maxHeight,
                                                                  @RequestParam(required = false) Double minWidth,
                                                                  @RequestParam(required = false) Double maxWidth,
                                                                  @RequestParam(required = false) Double minLength,
                                                                  @RequestParam(required = false) Double maxLength,
                                                                  @RequestParam(required = false) Double minMaximumLoad,
                                                                  @RequestParam(required = false) Double maxMaximumLoad,
                                                                  @NotNull final Pageable pageable) {
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        final Page<Product> products = productService.findProductsByPageable(category,
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
                pageable);
        return new ResponseEntity<>(products.map(product -> map(product, ProductFullDto.class)), HttpStatus.OK);
    }


    @GetMapping
    private ResponseEntity findAll(@NotNull final Pageable pageable) {

        return ResponseEntity.ok(productService.findAll(pageable).map(product -> map(product, ProductFullDto.class)));
    }

}
