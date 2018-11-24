package com.web.edu.internetshop.dto.model.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.model.utils.parser.DateDeserializer;
import com.web.edu.internetshop.model.utils.parser.DateSerializer;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

public class PromoCodeRequestAddDto {
    @NotNull
    private List<IdDto> product;
    @NotNull
    private Timestamp dateStart;
    @NotNull
    private Timestamp dateEnd;
    @NotNull
    private Long maxCount;
    @NotNull
    @NotEmpty
    private String code;
    private Float discount;

    public Float getDiscount() {
        return discount;
    }

    public PromoCodeRequestAddDto setDiscount(Float discount) {
        this.discount = discount;
        return this;
    }

    public List<IdDto> getProduct() {
        return product;
    }

    public PromoCodeRequestAddDto setProduct(List<IdDto> product) {
        this.product = product;
        return this;
    }

    @JsonSerialize(using = DateSerializer.class)
    public Timestamp getDateStart() {
        return dateStart;
    }

    @JsonDeserialize(using = DateDeserializer.class)
    public PromoCodeRequestAddDto setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    @JsonSerialize(using = DateSerializer.class)
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    @JsonDeserialize(using = DateDeserializer.class)
    public PromoCodeRequestAddDto setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public Long getMaxCount() {
        return maxCount;
    }

    public PromoCodeRequestAddDto setMaxCount(Long maxCount) {
        this.maxCount = maxCount;
        return this;
    }

    public String getCode() {
        return code;
    }

    public PromoCodeRequestAddDto setCode(String code) {
        this.code = code;
        return this;
    }
}
