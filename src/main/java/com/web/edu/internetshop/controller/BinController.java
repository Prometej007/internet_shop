package com.web.edu.internetshop.controller;

import com.web.edu.internetshop.dto.model.request.BinAddRequestDTO;
import com.web.edu.internetshop.dto.model.request.BinPriceRequestDTO;
import com.web.edu.internetshop.dto.utils.builder.Builder;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.service.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/bin")
public class BinController {

    @Autowired
    private BinService binService;

    @PostMapping("/price")
    private ResponseEntity getPrice(@RequestBody BinPriceRequestDTO binAddRequestDTO) {
        return ResponseEntity.ok(binService.getPrice(Builder.map(binAddRequestDTO, Bin.class)));
    }

    @PostMapping("/buy")
    private ResponseEntity getPrice(@RequestBody BinAddRequestDTO binAddRequestDTO, Principal principal) {
        Bin bin=Builder.map(binAddRequestDTO, Bin.class);
        System.out.println(binAddRequestDTO);
        binService.create(bin, principal);
        return ResponseEntity.ok().build();
    }

}
