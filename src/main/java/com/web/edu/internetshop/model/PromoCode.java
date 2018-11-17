package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity
@DynamicUpdate
public class PromoCode extends DateCreate<PromoCode> {
    @ManyToMany
    private List<Product> product;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private Long maxCount;
    @OneToMany(mappedBy = "promoCode")
    private List<Bin> bins;
    private String code;
    //0-100%
private Float discount;

    public Float getDiscount() {
        return discount;
    }

    public PromoCode setDiscount(Float discount) {
        this.discount = discount;
        return this;
    }

    public String getCode() {
        return code;
    }

    public PromoCode setCode(String code) {
        this.code = code;
        return this;
    }

    public List<Product> getProduct() {
        return product;
    }

    public PromoCode setProduct(List<Product> product) {
        this.product = product;
        return this;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public PromoCode setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public PromoCode setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public Long getMaxCount() {
        return maxCount;
    }

    public PromoCode setMaxCount(Long maxCount) {
        this.maxCount = maxCount;
        return this;
    }

    public List<Bin> getBins() {
        return bins;
    }

    public PromoCode setBins(List<Bin> bins) {
        this.bins = bins;
        return this;
    }
}
