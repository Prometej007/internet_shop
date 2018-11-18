package com.web.edu.internetshop.controller;

import com.web.edu.internetshop.dto.model.request.MaterialsAddRequestDTO;
import com.web.edu.internetshop.model.product.Materials;
import com.web.edu.internetshop.service.MaterialService;
import javafx.scene.paint.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.web.edu.internetshop.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;


    @PostMapping
    private ResponseEntity create(@Valid @RequestBody MaterialsAddRequestDTO addRequestDTO) {
        materialService.create(map(addRequestDTO, Materials.class));
        return ResponseEntity.ok().build();
    }

}
