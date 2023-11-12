package com.company.hotel.security.service;

import com.company.hotel.security.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    User saveUser(User user);
}
