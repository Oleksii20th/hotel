package com.company.hotel.login.dto;

import com.company.hotel.login.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private long id;

    private String username;

    private String password;

    private boolean enabled;

    private Set<Role> roles;

}
