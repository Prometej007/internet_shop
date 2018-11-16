package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.enums.ProductType;
import com.web.edu.internetshop.model.enums.SoftnessType;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Product extends DateCreate<Product> {


    @OneToOne
    private Dictionary name;
    @ManyToOne
    private Dictionary description;
    @OneToOne
    private Image image;
    @ManyToOne
    private Category category;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<SoftnessType> softnessTypes;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private ProductType productType;

    @ManyToMany
    private List<Materials> materials;

    private Double height;

    private Double width;

    private Double length;

    private Double maximumLoad;

    private BigDecimal price;

    private Boolean canBuy;

    private Boolean news;

    private Boolean winterSummerOption;


    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", description=" + description +
                ", image=" + image +
                ", category=" + category +
                ", softnessTypes=" + softnessTypes +
                ", productType=" + productType +
                ", materials=" + materials +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", maximumLoad=" + maximumLoad +
                ", price=" + price +
                ", canBuy=" + canBuy +
                ", news=" + news +
                ", winterSummerOption=" + winterSummerOption +
                '}';
    }
}
