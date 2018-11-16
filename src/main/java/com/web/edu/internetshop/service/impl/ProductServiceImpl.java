package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.Product;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.ProductRepository;
import com.web.edu.internetshop.service.DictionaryService;
import com.web.edu.internetshop.service.ImageService;
import com.web.edu.internetshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Product lastModification(LastModification<Product> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }
}
