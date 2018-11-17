package com.web.edu.internetshop.service.utils;

import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.repository.BinRepository;
import com.web.edu.internetshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@Component
public class GenerateUuid {
    private String pull = "QWERTYUIOPADFGHJKLZXCVBNMqwertyuiopadfghjklzxcvbnm123456789";
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BinRepository binRepository;

    public User generateUUID(User user) {
        return user.setUuid(generateUUID());
    }


    public String generateUUID() {
        String uuid = null;
        do {
            uuid = UUID.randomUUID().toString();
        } while (ofNullable(userRepository.findByUuid(uuid)).isPresent());
        return uuid;
    }


    public User generatePassword(User user) {
        return user.setPassword(generatePassword());
    }

    public String generatePassword() {
        return generate(10);
    }

    public Bin generateOrder(Bin bin) {
        return bin.setOrder(generateOrder());
    }

    public String generateOrder() {
        return generate(15, "0123456789");
    }

    private String generate(long length) {
        return generate(length, pull);
    }

    private String generate(long length, String pull) {
        StringBuilder builder = new StringBuilder();
        while (builder.length() < length) {
            builder.append(pull.charAt(new Random().nextInt(pull.length())));
        }
        return builder.toString();
    }
}
