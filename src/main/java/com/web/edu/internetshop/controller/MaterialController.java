package com.web.edu.internetshop.controller;

import com.web.edu.internetshop.dto.model.MaterialsDto;
import com.web.edu.internetshop.dto.model.request.MaterialsAddRequestDTO;
import com.web.edu.internetshop.model.product.Materials;
import com.web.edu.internetshop.service.MaterialService;
import javafx.scene.paint.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

    @GetMapping
    private ResponseEntity findAll(@NotNull final Pageable pageable) {
        return ResponseEntity.ok(materialService.findAll(pageable).map(materials -> map(materials, MaterialsDto.class)));
    }

    @GetMapping("/active")
    private ResponseEntity findAllAvailable(@NotNull final Pageable pageable) {
        return ResponseEntity.ok(materialService.findAllAvailable(pageable).map(materials -> map(materials, MaterialsDto.class)));
    }

}
