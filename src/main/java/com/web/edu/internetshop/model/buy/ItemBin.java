package com.web.edu.internetshop.model.buy;

import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;


@Entity
@DynamicUpdate
public class ItemBin extends DateCreate <ItemBin> {
    @OneToOne
    private Product product;
    @ManyToOne
    private Bin bin;
    private Integer count;
    private BigDecimal pricePerOne;

    public Product getProduct() {
        return product;
    }

    public ItemBin setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Bin getBin() {
        return bin;
    }

    public ItemBin setBin(Bin bin) {
        this.bin = bin;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public ItemBin setCount(Integer count) {
        this.count = count;
        return this;
    }

    public BigDecimal getPricePerOne() {
        return pricePerOne;
    }

    public ItemBin setPricePerOne(BigDecimal pricePerOne) {
        this.pricePerOne = pricePerOne;
        return this;
    }
}
