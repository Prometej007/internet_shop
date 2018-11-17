package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.dto.utils.annotations.Dto;

import javax.persistence.Column;

@Dto
public class DictionaryDto {

    private String valueEn;
    private String valueRu;
    private String valueUa;

    public String getValueEn() {
        return valueEn;
    }

    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }

    public String getValueRu() {
        return valueRu;
    }

    public void setValueRu(String valueRu) {
        this.valueRu = valueRu;
    }

    public String getValueUa() {
        return valueUa;
    }

    public void setValueUa(String valueUa) {
        this.valueUa = valueUa;
    }
}
