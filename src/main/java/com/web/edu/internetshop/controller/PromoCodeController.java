package com.web.edu.internetshop.controller;

import com.web.edu.internetshop.dto.model.PromocodeFullDto;
import com.web.edu.internetshop.dto.model.request.PromoCodeRequestAddDto;
import com.web.edu.internetshop.dto.utils.builder.Builder;
import com.web.edu.internetshop.model.PromoCode;
import com.web.edu.internetshop.service.PromoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/promo-code")
public class PromoCodeController {

    @Autowired
    private PromoCodeService promoCodeService;

    @PostMapping
    private ResponseEntity create(@Valid @RequestBody PromoCodeRequestAddDto promoCodeRequestAddDto) {
        promoCodeService.create(Builder.map(promoCodeRequestAddDto, PromoCode.class));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/is")
    private ResponseEntity is(@RequestParam String code) {
        return ResponseEntity.ok(ofNullable(promoCodeService.findByCode(code)).isPresent());
    }

    @GetMapping
    private ResponseEntity findAll(final Pageable pageable) {
        return ResponseEntity.ok(promoCodeService.findAll(pageable).map(promoCode -> Builder.map(promoCode, PromocodeFullDto.class)));
    }

    @GetMapping("/{id}")
    private ResponseEntity findAll(@PathVariable Long id) {
        return ResponseEntity.ok(Builder.map(promoCodeService.findOne(id), PromocodeFullDto.class));
    }


}
