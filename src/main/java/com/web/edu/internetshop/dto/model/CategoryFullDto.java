package com.web.edu.internetshop.dto.model;

import java.util.List;

public class CategoryFullDto extends CategoryShortDto {

    private List<ProductFullDto> products;

    public List<ProductFullDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductFullDto> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryFullDto{" +
                "products=" + products +
                ", image=" + image +
                ", order=" + order +
                ", name=" + name +
                ", description=" + description +
                '}';
    }
}
