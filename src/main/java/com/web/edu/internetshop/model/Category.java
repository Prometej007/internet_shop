package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.utils.pattern.DateCreate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Category extends DateCreate<Category> {

    @OneToOne
    private Image image;
    @Column(name = "_order")
    private Integer order;
    @OneToOne
    private Dictionary name;
    @OneToOne
    private Dictionary description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "image=" + image +
                ", order=" + order +
                ", name=" + name +
                ", description=" + description +
                ", products=" + products +
                '}';
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
