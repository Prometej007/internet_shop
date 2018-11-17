package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.User;

public interface MailService {


    User sendConfirmRegistration(User user);

    User sendAutoRegistration(User user, String password);


}
