package com.company.hotel.security.service;

import com.company.hotel.security.dto.UserDTO;
import com.company.hotel.security.entity.User;
import com.company.hotel.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceViewImpl implements UserServiceView {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserDtoByUsername(String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return userMapper.mapEntityToDto(user);
        }
        return null;
    }
}
