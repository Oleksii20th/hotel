package com.company.hotel.security.service;

import com.company.hotel.security.dto.UserDTO;
import com.company.hotel.security.entity.User;
import com.company.hotel.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceViewImpl implements UserServiceView {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserDtoByUsername(String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.map(users -> userMapper.mapEntityToDto(users)).orElse(null);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.mapDtoToEntity(userDTO);
        userService.saveUser(user);
        return userMapper.mapEntityToDto(user);
    }
}
