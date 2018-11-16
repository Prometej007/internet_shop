package com.web.edu.internetshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class InternetShopApplication {
    private static final Logger logger = Logger.getLogger(InternetShopApplication.class.getName());

    public static void main(String[] args) {

        SpringApplication.run(InternetShopApplication.class, args);
    }
}
