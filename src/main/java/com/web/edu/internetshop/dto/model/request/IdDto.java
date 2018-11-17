package com.web.edu.internetshop.dto.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class IdDto {
    @Min(0)
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public IdDto setId(Long id) {
        this.id = id;
        return this;
    }
}
