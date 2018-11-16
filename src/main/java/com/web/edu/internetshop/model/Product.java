package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.enums.SoftnessType;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;

import javax.persistence.*;
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
    private List<SoftnessType> softness;
    @ManyToMany
    private List<Materials> materials;

    private Double height;
    private Double weight;
    private Double length;


    private Boolean canBuy;
    private Boolean news;


    public Dictionary getName() {
        return name;
    }

    public void setName(Dictionary name) {
        this.name = name;
    }

    public Dictionary getDescription() {
        return description;
    }

    public void setDescription(Dictionary description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<SoftnessType> getSoftness() {
        return softness;
    }

    public void setSoftness(List<SoftnessType> softness) {
        this.softness = softness;
    }

    public List<Materials> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Materials> materials) {
        this.materials = materials;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Boolean getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(Boolean canBuy) {
        this.canBuy = canBuy;
    }

    public Boolean getNews() {
        return news;
    }

    public void setNews(Boolean news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", description=" + description +
                ", image=" + image +
                ", category=" + category +
                ", softness=" + softness +
                ", materials=" + materials +
                ", height=" + height +
                ", weight=" + weight +
                ", length=" + length +
                ", canBuy=" + canBuy +
                ", news=" + news +
                '}';
    }


}
