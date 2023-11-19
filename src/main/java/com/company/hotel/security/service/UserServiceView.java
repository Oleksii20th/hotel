package com.company.hotel.security.service;

import com.company.hotel.security.dto.UserDTO;

public interface UserServiceView {

    UserDTO getUserDtoByUsername(String username);

    UserDTO save(UserDTO userDTO);

}
