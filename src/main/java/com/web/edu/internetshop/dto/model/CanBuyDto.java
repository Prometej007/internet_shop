package com.web.edu.internetshop.dto.model;

import javax.validation.constraints.NotNull;

public class CanBuyDto {

    @NotNull
    private Boolean canBuy;

    public Boolean getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(Boolean canBuy) {
        this.canBuy = canBuy;
    }
}
