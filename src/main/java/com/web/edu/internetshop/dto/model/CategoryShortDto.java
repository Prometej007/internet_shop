package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.dto.utils.annotations.Dto;
import com.web.edu.internetshop.model.product.Dictionary;
import com.web.edu.internetshop.model.product.Image;

import javax.persistence.Column;
import javax.persistence.OneToOne;

@Dto
public class CategoryShortDto {

    protected ImageDto image;
    protected Integer order;
    protected DictionaryDto name;
    protected DictionaryDto description;

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public DictionaryDto getName() {
        return name;
    }

    public void setName(DictionaryDto name) {
        this.name = name;
    }

    public DictionaryDto getDescription() {
        return description;
    }

    public void setDescription(DictionaryDto description) {
        this.description = description;
    }
}
