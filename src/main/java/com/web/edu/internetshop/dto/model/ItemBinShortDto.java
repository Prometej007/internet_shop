package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.dto.utils.annotations.Dto;
import com.web.edu.internetshop.model.buy.Bin;

import java.math.BigDecimal;

@Dto
public class ItemBinShortDto {

    protected Integer count;
    protected BigDecimal pricePerOne;




    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPricePerOne() {
        return pricePerOne;
    }

    public void setPricePerOne(BigDecimal pricePerOne) {
        this.pricePerOne = pricePerOne;
    }
}
