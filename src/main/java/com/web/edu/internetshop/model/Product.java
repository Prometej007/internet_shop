package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.enums.ProductType;
import com.web.edu.internetshop.model.enums.SoftnessType;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity

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
    private ProductType productType;

    @ManyToMany
    private List<Materials> materials;

    private String model;

    private Double height;

    private Double width;

    private Double length;

    private Double maximumLoad;

    private BigDecimal price;

    private Boolean canBuy;

    private Boolean news;

    private Boolean winterSummerOption;

    public String getModel() {
        return model;
    }

    public Product setModel(String model) {
        this.model = model;
        return this;
    }

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

    public Dictionary getName() {
        return name;
    }

    public Product setName(Dictionary name) {
        this.name = name;
        return this;
    }

    public Dictionary getDescription() {
        return description;
    }

    public Product setDescription(Dictionary description) {
        this.description = description;
        return this;
    }

    public Image getImage() {
        return image;
    }

    public Product setImage(Image image) {
        this.image = image;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public List<SoftnessType> getSoftnessTypes() {
        return softnessTypes;
    }

    public Product setSoftnessTypes(List<SoftnessType> softnessTypes) {
        this.softnessTypes = softnessTypes;
        return this;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Product setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public List<Materials> getMaterials() {
        return materials;
    }

    public Product setMaterials(List<Materials> materials) {
        this.materials = materials;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public Product setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public Product setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public Product setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getMaximumLoad() {
        return maximumLoad;
    }

    public Product setMaximumLoad(Double maximumLoad) {
        this.maximumLoad = maximumLoad;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Boolean getCanBuy() {
        return canBuy;
    }

    public Product setCanBuy(Boolean canBuy) {
        this.canBuy = canBuy;
        return this;
    }

    public Boolean getNews() {
        return news;
    }

    public Product setNews(Boolean news) {
        this.news = news;
        return this;
    }

    public Boolean getWinterSummerOption() {
        return winterSummerOption;
    }

    public Product setWinterSummerOption(Boolean winterSummerOption) {
        this.winterSummerOption = winterSummerOption;
        return this;
    }
}
