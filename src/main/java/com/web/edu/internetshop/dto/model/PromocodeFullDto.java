package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.model.buy.Bin;

import java.sql.Timestamp;
import java.util.List;

public class PromocodeFullDto extends PromocodeShortDto {

    private List<BinDto> bins;
    private List<ProductFullDto> product;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private Long maxCount;
    private Float discount;

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public List<BinDto> getBins() {
        return bins;
    }

    public void setBins(List<BinDto> bins) {
        this.bins = bins;
    }

    public List<ProductFullDto> getProduct() {
        return product;
    }

    public void setProduct(List<ProductFullDto> product) {
        this.product = product;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Long maxCount) {
        this.maxCount = maxCount;
    }
}
