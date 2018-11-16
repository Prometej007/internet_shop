package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.model.Category;
import com.web.edu.internetshop.model.Materials;
import com.web.edu.internetshop.model.Product;
import com.web.edu.internetshop.model.enums.ProductType;
import com.web.edu.internetshop.model.enums.SoftnessType;
import com.web.edu.internetshop.service.impl.ImageServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toList;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest extends Assert {

    private static final Logger logger = Logger.getLogger(ProductRepositoryTest.class.getName());

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MaterialsRepository materialsRepository;

    private Product product;

    @Before
    public void before() {
        this.product = productRepository.save(
                new Product()
                        .setMaterials(Collections.singletonList(materialsRepository.save(new Materials())))
                        .setCategory(categoryRepository.save(new Category()))
                        .setSoftnessTypes(Collections.singletonList(SoftnessType.HARD))
                .setProductType(ProductType.DOUBLE_SIDED)
                .setWinterSummerOption(true).setPrice(new BigDecimal(100))
        );
        this.product=productRepository.findOne(product.getId());
    }

    @Test
    public void filter() {
        System.err.println(product.getSoftnessTypes());
        System.err.println(product.getId());
        System.err.println(product.getCategory().getId());
        System.err.println(product.getMaterials().size());
        assertEquals(productRepository.filter(
                Collections.singletonList(product.getCategory().getId()),
                product.getMaterials().stream().map(Materials::getId).collect(toList()),
                Collections.singletonList(SoftnessType.HARD.ordinal()),
                Collections.singletonList(product.getProductType().ordinal()),
                product.getWinterSummerOption()
,new BigDecimal(0),new BigDecimal(1000)
        ).size(), 1);
    }

}