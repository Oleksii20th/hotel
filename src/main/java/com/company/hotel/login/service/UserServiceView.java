package com.company.hotel.login.service;

import com.company.hotel.login.dto.UserDTO;
import com.company.hotel.login.entity.User;

public interface UserServiceView {

    UserDTO getUserDtoByUsername(String username);

}
