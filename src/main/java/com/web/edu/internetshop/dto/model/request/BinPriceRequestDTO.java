package com.web.edu.internetshop.dto.model.request;

import com.web.edu.internetshop.dto.model.ItemBinFullDto;
import com.web.edu.internetshop.dto.model.PromocodeShortDto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BinPriceRequestDTO {
    @NotNull
    private List<ItemBinFullDto> itemBins;

    private PromocodeShortDto promoCode;

    public List<ItemBinFullDto> getItemBins() {
        return itemBins;
    }

    public BinPriceRequestDTO setItemBins(List<ItemBinFullDto> itemBins) {
        this.itemBins = itemBins;
        return this;
    }

    public PromocodeShortDto getPromoCode() {
        return promoCode;
    }

    public BinPriceRequestDTO setPromoCode(PromocodeShortDto promoCode) {
        this.promoCode = promoCode;
        return this;
    }
}
