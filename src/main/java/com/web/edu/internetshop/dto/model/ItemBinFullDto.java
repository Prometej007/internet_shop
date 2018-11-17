package com.web.edu.internetshop.dto.model;

public class ItemBinFullDto extends ItemBinShortDto {

    private ProductFullDto productFullDto;

    public ProductFullDto getProductFullDto() {
        return productFullDto;
    }

    public void setProductFullDto(ProductFullDto productFullDto) {
        this.productFullDto = productFullDto;
    }

    @Override
    public String toString() {
        return "ItemBinFullDto{" +
                "productFullDto=" + productFullDto +
                ", bin=" + bin +
                ", count=" + count +
                ", pricePerOne=" + pricePerOne +
                '}';
    }
}
