package com.web.edu.internetshop.dto.model.request;

import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.enums.BinStatusType;

import javax.validation.constraints.NotNull;

public class BinStatus {

    @NotNull
    private BinStatusType type;
    @NotNull
    private String comment;
    @NotNull
    private Bin bin;

    public BinStatusType getType() {
        return type;
    }

    public void setType(BinStatusType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }
}
