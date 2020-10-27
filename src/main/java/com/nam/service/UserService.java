package com.nam.service;

import com.nam.data.model.NamUser;

import java.util.Optional;

public interface UserService {

    NamUser getUser(Long userId);

    NamUser addUser(String name, String surName, String email, String password);

    NamUser checkUser(String email, String password);
}
