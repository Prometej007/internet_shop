package com.web.edu.internetshop.model.buy;

import com.web.edu.internetshop.model.enums.BinStatusType;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@DynamicUpdate
public class BinStatus extends DateCreate<BinStatus> {
    @Enumerated
    private BinStatusType type;
    @Column(columnDefinition = "TEXT")
    private String comment;
    @ManyToOne
    private Bin bin;


    public Bin getBin() {
        return bin;
    }

    public BinStatus setBin(Bin bin) {
        this.bin = bin;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public BinStatus setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public BinStatusType getType() {
        return type;
    }

    public BinStatus setType(BinStatusType type) {
        this.type = type;
        return this;
    }
}
