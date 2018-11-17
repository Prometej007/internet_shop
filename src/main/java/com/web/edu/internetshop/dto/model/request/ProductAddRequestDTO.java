package com.web.edu.internetshop.dto.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.edu.internetshop.dto.model.IdDto;
import com.web.edu.internetshop.model.enums.ProductType;
import com.web.edu.internetshop.model.enums.SoftnessType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class ProductAddRequestDTO {

    @NotNull
    private DictionaryAddRequestDTO name;
    @NotNull
    private DictionaryAddRequestDTO description;
    @NotNull
    private ImageAddRequestDTO image;
    @NotNull
    private IdDto category;
    @NotNull
    private IdDto materials;
    @NotNull
    private List<SoftnessType> softnessTypes;
    @NotNull
    private ProductType productType;
    @NotNull
    private String model;
    @NotNull
    @Min(0)
    private Double height;
    @NotNull
    @Min(0)
    private Double width;
    @NotNull
    @Min(0)
    private Double length;
    @NotNull
    @Min(0)
    private Double maximumLoad;
    @NotNull
    @JsonFormat (shape= JsonFormat.Shape.STRING)
    private BigDecimal price;
    @NotNull
    private Boolean canBuy;
    @NotNull
    private Boolean news;
    @NotNull
    private Boolean winterSummerOption;

    public DictionaryAddRequestDTO getName() {
        return name;
    }

    public void setName(DictionaryAddRequestDTO name) {
        this.name = name;
    }

    public DictionaryAddRequestDTO getDescription() {
        return description;
    }

    public void setDescription(DictionaryAddRequestDTO description) {
        this.description = description;
    }

    public ImageAddRequestDTO getImage() {
        return image;
    }

    public void setImage(ImageAddRequestDTO image) {
        this.image = image;
    }

    public IdDto getCategory() {
        return category;
    }

    public void setCategory(IdDto category) {
        this.category = category;
    }

    public IdDto getMaterials() {
        return materials;
    }

    public void setMaterials(IdDto materials) {
        this.materials = materials;
    }

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

    public Boolean getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(Boolean canBuy) {
        this.canBuy = canBuy;
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
}
