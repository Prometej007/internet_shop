package com.web.edu.internetshop.service;


import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.buy.ItemBin;

public interface ItemBinService extends GrudOperations<ItemBin> {
    ItemBin create(ItemBin itemBin, Bin bin);

}
