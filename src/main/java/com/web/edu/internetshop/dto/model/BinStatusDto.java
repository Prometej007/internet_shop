package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.dto.utils.annotations.Dto;
import com.web.edu.internetshop.model.enums.BinStatusType;

@Dto
public class BinStatusDto {

    private BinStatusType type;
    private String comment;
    private ItemBinFullDto bin;

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

    public ItemBinFullDto getBin() {
        return bin;
    }

    public void setBin(ItemBinFullDto bin) {
        this.bin = bin;
    }

    @Override
    public String toString() {
        return "BinStatusDto{" +
                "type=" + type +
                ", comment='" + comment + '\'' +
                ", bin=" + bin +
                '}';
    }
}
