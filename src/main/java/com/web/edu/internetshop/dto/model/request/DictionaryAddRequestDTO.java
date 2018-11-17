package com.web.edu.internetshop.dto.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class DictionaryAddRequestDTO {
    @NotNull
    @NotEmpty
    private String valueEn;
    @NotNull
    @NotEmpty
    private String valueRu;
    @NotNull
    @NotEmpty
    private String valueUa;

    public String getValueEn() {
        return valueEn;
    }

    public DictionaryAddRequestDTO setValueEn(String valueEn) {
        this.valueEn = valueEn;
        return this;
    }

    public String getValueRu() {
        return valueRu;
    }

    public DictionaryAddRequestDTO setValueRu(String valueRu) {
        this.valueRu = valueRu;
        return this;
    }

    public String getValueUa() {
        return valueUa;
    }

    public DictionaryAddRequestDTO setValueUa(String valueUa) {
        this.valueUa = valueUa;
        return this;
    }
}
