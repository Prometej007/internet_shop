package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.product.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService extends GrudOperations<Category> {

    Page<Category> findAll(Pageable pageable);

}
