package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.model.buy.Bin;

public interface MailService {


    User sendConfirmRegistration(User user);

    User sendAutoRegistration(User user, String password);

    Bin sendInfoNewBinStatus(Bin bin);


}
