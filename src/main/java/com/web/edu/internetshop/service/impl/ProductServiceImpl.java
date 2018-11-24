package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.ProductRepository;
import com.web.edu.internetshop.service.DictionaryService;
import com.web.edu.internetshop.service.ImageService;
import com.web.edu.internetshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ImageService imageService;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Product create(Product product) {
        return save(
                setLastModification(
                        setDefaultAvailable(
                                setDateCreate(
                                        product
                                                .setDescription(dictionaryService.create(product.getDescription()))
                                                .setImage(imageService.create(product.getImage())))
                                        .setName(dictionaryService.create(product.getName()))
                        )
                )

        );
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findOne(Product product) {
        return productRepository.findOne(product.getId());
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Product update(Product product) {
        return save(setLastModification(product));
    }

    @Override
    public Page<Product> findProductsByPageable(final List<Long> category,
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
                                                final Pageable pageable) {

        return productRepository.filter(category, materials, softness, productType, winterSummerOption, minPrice, maxPrice, minHeight, maxHeight, minWidth, maxWidth, minLength, maxLength, minMaximumLoad, maxMaximumLoad, pageable);
    }

    @Override
    public Product lastModification(LastModification<Product> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

    @Override
    public Boolean setAvailability(Long productId, boolean available) {
        Product product1 = findOne(productId);
        product1.setAvailable(available);
        save(product1);
        return true;
    }

    @Override
    public Boolean unlockBuy(Product product) {
        Product product1 = findOne(product);
        product1.setCanBuy(true);
        return true;
    }

    @Override
    public Boolean lockBuy(Product product) {
        Product product1 = findOne(product);
        product1.setCanBuy(false);
        return true;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
