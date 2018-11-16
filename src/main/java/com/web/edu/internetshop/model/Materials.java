package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@DynamicUpdate
@Entity
public class Materials extends DateCreate<Materials> {

    @OneToOne
    private Dictionary name;
    @OneToOne
    private Dictionary description;
    @OneToOne
    private Image image;

    @OneToOne
    private Product product;

    @Override
    public String toString() {
        return "Materials{" +
                "name=" + name +
                ", description=" + description +
                ", image=" + image +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public Materials setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Dictionary getName() {
        return name;
    }

    public Materials setName(Dictionary name) {
        this.name = name;
        return this;
    }

    public Dictionary getDescription() {
        return description;
    }

    public Materials setDescription(Dictionary description) {
        this.description = description;
        return this;
    }

    public Image getImage() {
        return image;
    }

    public Materials setImage(Image image) {
        this.image = image;
        return this;
    }

}
