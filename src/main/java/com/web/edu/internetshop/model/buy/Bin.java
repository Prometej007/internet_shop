package com.web.edu.internetshop.model.buy;

import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@DynamicUpdate
public class Bin extends DateCreate<Bin> {

    @OneToMany(mappedBy = "bin")
    private List<ItemBin> itemBins;
    @OneToOne
    private User user;
    @Column(name = "_order")
    private String order;
    private BigDecimal price;

    @OneToMany(mappedBy = "bin")
    private List<BinStatus> statuses;

    public List<BinStatus> getStatuses() {
        return statuses;
    }

    public Bin setStatuses(List<BinStatus> statuses) {
        this.statuses = statuses;
        return this;
    }

    public List<ItemBin> getItemBins() {
        return itemBins;
    }

    public Bin setItemBins(List<ItemBin> itemBins) {
        this.itemBins = itemBins;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Bin setUser(User user) {
        this.user = user;
        return this;
    }

    public String getOrder() {
        return order;
    }

    public Bin setOrder(String order) {
        this.order = order;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Bin setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
