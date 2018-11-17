package com.web.edu.internetshop.dto.model;


import java.util.List;

public class UserFullDto extends UserShortDto {


    private List<ProductFullDto> seeProducts;

    public List<ProductFullDto> getSeeProducts() {
        return seeProducts;
    }

    public void setSeeProducts(List<ProductFullDto> seeProducts) {
        this.seeProducts = seeProducts;
    }
}
