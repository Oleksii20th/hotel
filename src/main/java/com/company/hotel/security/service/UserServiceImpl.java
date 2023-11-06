package com.company.hotel.security.service;

import com.company.hotel.security.entity.User;
import com.company.hotel.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void savePassword(String username, String currentPassword, String newPassword, String confirmationPassword) throws IllegalArgumentException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        if (!passwordEncoder.matches(currentPassword, user.get().getPassword())) {
            throw new IllegalArgumentException("Wrong current password");
        }

        if (!newPassword.equals(confirmationPassword)) {
            throw new IllegalArgumentException("Password and confirmation do not match");
        }

        user.get().setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user.get());
    }
}
