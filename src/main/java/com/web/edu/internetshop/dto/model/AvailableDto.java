package com.web.edu.internetshop.dto.model;

import javax.validation.constraints.NotNull;

public class AvailableDto extends IdDto {

    @NotNull
    private Boolean available;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
