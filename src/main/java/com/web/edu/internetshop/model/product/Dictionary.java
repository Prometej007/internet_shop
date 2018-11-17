package com.web.edu.internetshop.model.product;


import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;

@DynamicUpdate
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

    public Dictionary setValueEn(String valueEn) {
        this.valueEn = valueEn;
        return this;
    }

    public String getValueRu() {
        return valueRu;
    }

    public Dictionary setValueRu(String valueRu) {
        this.valueRu = valueRu;
        return this;
    }

    public String getValueUa() {
        return valueUa;
    }

    public Dictionary setValueUa(String valueUa) {
        this.valueUa = valueUa;
        return this;
    }
}
