package com.web.edu.internetshop.dto.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CategoryAddRequestDTO {

    @NotNull
    private ImageAddRequestDTO image;
    @NotNull
    @Min(0)
    private Integer order;
    @NotNull
    private DictionaryAddRequestDTO name;
    @NotNull
    private DictionaryAddRequestDTO description;

    public ImageAddRequestDTO getImage() {
        return image;
    }

    public CategoryAddRequestDTO setImage(ImageAddRequestDTO image) {
        this.image = image;
        return this;
    }

    public Integer getOrder() {
        return order;
    }

    public CategoryAddRequestDTO setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public DictionaryAddRequestDTO getName() {
        return name;
    }

    public CategoryAddRequestDTO setName(DictionaryAddRequestDTO name) {
        this.name = name;
        return this;
    }

    public DictionaryAddRequestDTO getDescription() {
        return description;
    }

    public CategoryAddRequestDTO setDescription(DictionaryAddRequestDTO description) {
        this.description = description;
        return this;
    }
}
