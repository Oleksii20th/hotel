package com.company.hotel.login.service;

import com.company.hotel.login.entity.User;

public interface UserService {

    User findByUsername(String username);

}
