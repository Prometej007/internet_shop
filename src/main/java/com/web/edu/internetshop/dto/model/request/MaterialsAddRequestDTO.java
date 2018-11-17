package com.web.edu.internetshop.dto.model.request;

import com.web.edu.internetshop.model.product.Dictionary;

import javax.validation.constraints.NotNull;

public class MaterialsAddRequestDTO {


    @NotNull
    private DictionaryAddRequestDTO name;
    @NotNull
    private DictionaryAddRequestDTO description;
    @NotNull
    private ImageAddRequestDTO image;

    @Override
    public String toString() {
        return "MaterialsAddRequestDTO{" +
                "name=" + name +
                ", description=" + description +
                ", image=" + image +
                '}';
    }

    public DictionaryAddRequestDTO getName() {
        return name;
    }

    public void setName(DictionaryAddRequestDTO name) {
        this.name = name;
    }

    public DictionaryAddRequestDTO getDescription() {
        return description;
    }

    public void setDescription(DictionaryAddRequestDTO description) {
        this.description = description;
    }

    public ImageAddRequestDTO getImage() {
        return image;
    }

    public void setImage(ImageAddRequestDTO image) {
        this.image = image;
    }
}
