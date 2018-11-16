package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.service.impl.ImageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

    private static final Logger logger = Logger.getLogger(ProductRepositoryTest.class.getName());

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void filter(){
        productRepository.filter(Collections.singletonList(1L)).stream().forEach(product -> {
            logger.log(Level.ALL,product.getId().toString());
        });
    }

}