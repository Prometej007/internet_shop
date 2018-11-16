package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.utils.pattern.DateCreate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Materials extends DateCreate<Materials> {

    @OneToOne
    private Dictionary name;
    @OneToOne
    private Dictionary description;
    @OneToOne
    private Image image;

    @Override
    public String toString() {
        return "Materials{" +
                "name=" + name +
                ", description=" + description +
                ", image=" + image +
                '}';
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
