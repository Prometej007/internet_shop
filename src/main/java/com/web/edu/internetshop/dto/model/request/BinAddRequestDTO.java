package com.web.edu.internetshop.dto.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.edu.internetshop.dto.model.ItemBinFullDto;
import com.web.edu.internetshop.dto.model.PromocodeShortDto;
import com.web.edu.internetshop.dto.model.UserFullDto;
import com.web.edu.internetshop.model.PromoCode;
import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.model.buy.ItemBin;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class BinAddRequestDTO {

    @NotNull
    private List<ItemBinFullDto> itemBins;
    @NotNull
    private UserFullDto user;
    @NotNull
    private String order;
    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private BigDecimal price;
    @NotNull
    @JsonFormat (shape= JsonFormat.Shape.STRING)
    private BigDecimal discount;
    @NotNull
    private String comment;
    @NotNull
    private PromocodeShortDto promoCode;


    public List<ItemBinFullDto> getItemBins() {
        return itemBins;
    }

    public void setItemBins(List<ItemBinFullDto> itemBins) {
        this.itemBins = itemBins;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserFullDto getUser() {
        return user;
    }

    public void setUser(UserFullDto user) {
        this.user = user;
    }

    public PromocodeShortDto getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(PromocodeShortDto promoCode) {
        this.promoCode = promoCode;
    }
}
