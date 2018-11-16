package com.web.edu.internetshop.service.utils;

import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateUuid {

    @Autowired
    private UserRepository userRepository;

    public User generateuuid(User user) {
        return user.setUuid(generateuuid());
    }

    public String generateuuid() {
        String uuid = null;
        do {
            uuid = UUID.randomUUID().toString();
        } while (userRepository.findByUuid(uuid) != null);
        return uuid;
    }
}
