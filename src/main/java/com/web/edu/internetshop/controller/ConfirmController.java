package com.web.edu.internetshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirm")
public class ConfirmController {


    @Value("${client.url}")
    private String urlClient;


    @GetMapping("/registration/{uuid}")
    private String registration(@PathVariable String uuid) {
        //todo confirm reg
        return "redirect:" + urlClient;
    }

}
