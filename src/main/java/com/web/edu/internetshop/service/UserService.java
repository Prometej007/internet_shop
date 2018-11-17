package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.service.GrudOperations;

public interface UserService extends GrudOperations<User> {

    User getForBuy(User user);

    User autoCreate(User user);

    User findByEmail(User user);

    User findByEmail(String email);

}
