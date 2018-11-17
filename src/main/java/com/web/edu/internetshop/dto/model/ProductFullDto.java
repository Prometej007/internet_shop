package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.model.enums.ProductType;
import com.web.edu.internetshop.model.enums.SoftnessType;
import com.web.edu.internetshop.model.product.Image;

import java.util.List;

public class ProductFullDto extends ProductShortDto {

    private List<SoftnessType> softnessTypes;

    private ProductType productType;

    private Boolean canBuy;

    private Boolean available;

    private Boolean news;

    private Boolean winterSummerOption;

    private ImageDto image;//todo

    public List<SoftnessType> getSoftnessTypes() {
        return softnessTypes;
    }

    public void setSoftnessTypes(List<SoftnessType> softnessTypes) {
        this.softnessTypes = softnessTypes;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Boolean getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(Boolean canBuy) {
        this.canBuy = canBuy;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getNews() {
        return news;
    }

    public void setNews(Boolean news) {
        this.news = news;
    }

    public Boolean getWinterSummerOption() {
        return winterSummerOption;
    }

    public void setWinterSummerOption(Boolean winterSummerOption) {
        this.winterSummerOption = winterSummerOption;
    }


    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }
}
