package com.web.edu.internetshop.controller;

import com.web.edu.internetshop.dto.model.CategoryShortDto;
import com.web.edu.internetshop.dto.model.request.CategoryAddRequestDTO;
import com.web.edu.internetshop.model.product.Category;
import com.web.edu.internetshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.web.edu.internetshop.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    private ResponseEntity create(@Valid @RequestBody CategoryAddRequestDTO categoryAddRequestDTO) {
        categoryService.create(map(categoryAddRequestDTO, Category.class));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    private ResponseEntity findAll(@NotNull final Pageable pageable) {
        return ResponseEntity.ok(categoryService.findAll(pageable).map(category -> map(category, CategoryShortDto.class)));
    }

    @GetMapping("/active")
    private ResponseEntity findAllAvailable(@NotNull final Pageable pageable) {
        return ResponseEntity.ok(categoryService.findAllAvailable(pageable).map(category -> map(category, CategoryShortDto.class)));
    }


}
