package com.web.edu.internetshop.service.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Validation {
    public static void checkId(Long id) {
        if (id == null || id < 0)
            throw new RuntimeException("invalid id");
    }

    public static void checkString(String string) {
        if (string == null)
            throw new RuntimeException(string + " must be not null");
    }

    public static void checkSave(Object object) {
        if (object == null)
            throw new RuntimeException("null");
    }

    public static void checkJson(String json) {
        try {
            new ObjectMapper().readTree(String.valueOf(json));
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("json is null or empty");
        }
    }

}
