package com.company.hotel.security.service;

import com.company.hotel.security.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    void savePassword(String username, String currentPassword, String newPassword, String confirmationPassword);
}
