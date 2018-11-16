package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
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

}
