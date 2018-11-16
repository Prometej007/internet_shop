package com.web.edu.internetshop.model;


import com.web.edu.internetshop.model.utils.pattern.DateCreate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dictionary extends DateCreate<Dictionary> {

    @Column(columnDefinition = "TEXT")
    private String valueEn;
    @Column(columnDefinition = "TEXT")
    private String valueRu;
    @Column(columnDefinition = "TEXT")
    private String valueUa;

    @Override
    public String toString() {
        return "Dictionary{" +
                "valueEn='" + valueEn + '\'' +
                ", valueRu='" + valueRu + '\'' +
                ", valueUa='" + valueUa + '\'' +
                '}';
    }

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
