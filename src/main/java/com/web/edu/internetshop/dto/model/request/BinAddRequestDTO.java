package com.web.edu.internetshop.dto.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.edu.internetshop.model.PromoCode;
import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.model.buy.ItemBin;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class BinAddRequestDTO {

    @NotNull
    private List<ItemBin> itemBins;
    @NotNull
    private User user;
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
    private PromoCode promoCode;

    public List<ItemBin> getItemBins() {
        return itemBins;
    }

    public void setItemBins(List<ItemBin> itemBins) {
        this.itemBins = itemBins;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public PromoCode getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(PromoCode promoCode) {
        this.promoCode = promoCode;
    }
}
