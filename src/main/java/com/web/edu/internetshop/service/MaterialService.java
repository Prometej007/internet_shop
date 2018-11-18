package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.product.Materials;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaterialService extends GrudOperations<Materials>{

    Page<Materials> findAll(Pageable pageable);
}
