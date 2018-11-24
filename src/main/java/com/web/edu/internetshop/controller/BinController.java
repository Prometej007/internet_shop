package com.web.edu.internetshop.controller;

import com.web.edu.internetshop.dto.model.BinDto;
import com.web.edu.internetshop.dto.model.request.BinAddRequestDTO;
import com.web.edu.internetshop.dto.model.request.BinPriceRequestDTO;
import com.web.edu.internetshop.dto.utils.builder.Builder;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.buy.BinStatus;
import com.web.edu.internetshop.model.enums.BinStatusType;
import com.web.edu.internetshop.service.BinService;
import com.web.edu.internetshop.service.BinStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.security.Principal;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/bin")
public class BinController {

    @Autowired
    private BinService binService;
    @Autowired
    private BinStatusService binStatusService;

    @PostMapping("/price")
    private ResponseEntity getPrice(@RequestBody BinPriceRequestDTO binAddRequestDTO) {
        return ResponseEntity.ok(binService.getPrice(Builder.map(binAddRequestDTO, Bin.class)));
    }

    @PostMapping("/buy")
    private ResponseEntity getPrice(@RequestBody BinAddRequestDTO binAddRequestDTO, Principal principal) {
        Bin bin = Builder.map(binAddRequestDTO, Bin.class);
        System.out.println(binAddRequestDTO);
        binService.create(bin, principal);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    private ResponseEntity getPrice(
            @RequestParam(required = false) BinStatusType type,
            @NotNull final Pageable pageable) {
        if (ofNullable(type).isPresent())
            return ResponseEntity.ok(binService.filter(type, pageable).map(bin -> Builder.map(bin, BinDto.class)));
        else
            return ResponseEntity.ok(binService.findAll(pageable).map(bin -> Builder.map(bin, BinDto.class)));
    }

    @GetMapping("/{id}")
    private ResponseEntity findOne(@PathVariable Long id) {
        return ResponseEntity.ok(Builder.map(binService.findOne(id), BinDto.class));
    }

    @PostMapping("/add-new-status")
    private ResponseEntity addNewStatus(
            @RequestParam(required = false) String comment,
            @RequestParam Long id,
            @RequestParam BinStatusType type
    ) {
        binStatusService.create(type, id, comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
