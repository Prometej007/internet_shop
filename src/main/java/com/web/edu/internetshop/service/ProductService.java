package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.product.Product;

public interface ProductService extends GrudOperations<Product> {

    Boolean isAvailable(Product product);
    Boolean notAvailable(Product product);
    Boolean unlockBuy(Product product);
    Boolean lockBuy(Product product);
}
