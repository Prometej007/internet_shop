package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.buy.ItemBin;

import java.math.BigDecimal;
import java.security.Principal;

public interface BinService extends GrudOperations<Bin> {

    Bin create(Bin bin, Principal principal);

    BigDecimal getPrice(Bin bin);

}
