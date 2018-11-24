package com.web.edu.internetshop.dto.model;

public class ItemBinFullDto extends ItemBinShortDto {

    private ProductFullDto product;

    public ProductFullDto getProduct() {
        return product;
    }

    public ItemBinFullDto setProduct(ProductFullDto product) {
        this.product = product;
        return this;
    }
}
