package com.web.edu.internetshop.dto.model;


import com.web.edu.internetshop.dto.utils.annotations.Dto;
import com.web.edu.internetshop.model.product.Dictionary;

import java.math.BigDecimal;

@Dto
public class ProductShortDto {

    protected DictionaryDto name;
    protected DictionaryDto description;
    protected String model;
    protected Double height;
    protected Double width;
    protected Double length;
    protected Double maximumLoad;
    protected BigDecimal price;


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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getMaximumLoad() {
        return maximumLoad;
    }

    public void setMaximumLoad(Double maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
