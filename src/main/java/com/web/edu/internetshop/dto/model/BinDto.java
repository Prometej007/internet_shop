package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.dto.model.request.IdDto;
import com.web.edu.internetshop.dto.utils.annotations.Dto;

import java.math.BigDecimal;
import java.util.List;

@Dto
public class BinDto extends IdDto {

    private List<ItemBinFullDto> itemBins;
    private UserShortDto user;
    private String order;
    private BigDecimal price;
    private BigDecimal discount;
    private String comment;
    private List<BinStatusDto> statuses;
    private String city;
    private String address;
    private PromocodeShortDto promoCode;

    @Override
    public String toString() {
        return "BinDto{" +
                "itemBins=" + itemBins +
                ", user=" + user +
                ", order='" + order + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", comment='" + comment + '\'' +
                ", statuses=" + statuses +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", promoCode=" + promoCode +
                '}';
    }

    public List<ItemBinFullDto> getItemBins() {
        return itemBins;
    }

    public void setItemBins(List<ItemBinFullDto> itemBins) {
        this.itemBins = itemBins;
    }

    public UserShortDto getUser() {
        return user;
    }

    public BinDto setUser(UserShortDto user) {
        this.user = user;
        return this;
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

    public List<BinStatusDto> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<BinStatusDto> statuses) {
        this.statuses = statuses;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PromocodeShortDto getPromoCode() {
        return promoCode;
    }

    public BinDto setPromoCode(PromocodeShortDto promoCode) {
        this.promoCode = promoCode;
        return this;
    }
}
