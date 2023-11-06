package com.company.hotel.security.service;

import com.company.hotel.security.entity.User;

public interface UserService {

    User findByUsername(String username);

}
