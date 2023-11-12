package com.company.hotel.security.dto;

import com.company.hotel.security.entity.Role;
import lombok.Data;

@Data
public class UserDTO {

    private long id;

    private String username;

    private String email;

    private String password;

    private boolean enabled;

    private Role roles;

}