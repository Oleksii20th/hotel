package com.company.hotel.security.service;

import com.company.hotel.security.dto.UserDTO;

public interface UserServiceView {

    UserDTO getUserDtoByUsername(String username);

    void changePassword(String username, String currentPassword, String newPassword, String confirmationPassword);

    void authentication(String username, String currentPassword, String newPassword, String confirmationPassword);
}
