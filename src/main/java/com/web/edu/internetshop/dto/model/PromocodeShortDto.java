package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.dto.utils.annotations.Dto;

@Dto
public class PromocodeShortDto {

    public String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "PromocodeShortDto{" +
                "code='" + code + '\'' +
                '}';
    }
}
