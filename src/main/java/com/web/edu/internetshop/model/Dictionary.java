package com.web.edu.internetshop.model;


import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
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

}
