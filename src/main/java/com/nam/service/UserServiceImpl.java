package com.nam.service;

import com.nam.data.model.NamUser;
import com.nam.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public NamUser getUser(Long userId) {
        NamUser namUser = userRepository.findByUserId(userId);
        return namUser;
    }

    @Override
    public NamUser addUser(String name, String surName, String email, String password) {
        NamUser namUser = new NamUser();
        namUser.setName(name);
        if (surName != null) {
            namUser.setSurName(surName);
        }
        namUser.setEmail(email);
        namUser.setPassword(password);
        userRepository.save(namUser);
        return namUser;
    }

    @Override
    public NamUser checkUser(String email, String password) {
        NamUser user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }
}
