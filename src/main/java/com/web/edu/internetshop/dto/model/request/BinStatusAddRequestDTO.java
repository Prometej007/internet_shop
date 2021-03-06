package com.web.edu.internetshop.dto.model.request;

import com.web.edu.internetshop.dto.model.BinDto;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.enums.BinStatusType;

import javax.validation.constraints.NotNull;

public class BinStatusAddRequestDTO {

    @NotNull
    private BinStatusType type;
    @NotNull
    private String comment;
    @NotNull
    private BinDto bin;

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

    public BinDto getBin() {
        return bin;
    }

    public void setBin(BinDto bin) {
        this.bin = bin;
    }
}
