package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.UserRepository;
import com.web.edu.internetshop.service.MailService;
import com.web.edu.internetshop.service.UserService;
import com.web.edu.internetshop.service.utils.GenerateUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GenerateUuid generateUuid;
    @Autowired
    private MailService mailService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public User create(User user) {
        return save(
                setLastModification(
                        user
                )
        );
    }

    @Override
    public User getForBuy(User user) {
        User u;
        if (ofNullable(u = findByEmail(user)).isPresent()) {
            return u;
        } else {
            u = autoCreate(user);
        }
        return u;
    }

    @Override
    public User autoCreate(User user) {
        User u = save(
                setLastModification(
                        generateUuid.generateUUID(
                                generateUuid.generatePassword(user)
                                        .setEnabled(true)
                                        .setAccountNonLocked(true))
                )
        );
        mailService.sendAutoRegistration(u, u.getPassword());
        save(save(u.setPassword(passwordEncoder.encode(u.getPassword()))));
        return u;
    }

    @Override
    public User findByEmail(User user) {
        return findByEmail(user.getEmail());
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(User user) {
        return findOne(user.getId());
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public User update(User user) {
        return save(setLastModification(user));
    }

    @Override
    public User lastModification(LastModification<User> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

}
