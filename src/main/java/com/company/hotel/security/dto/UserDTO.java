package com.company.hotel.security.dto;

import com.company.hotel.security.entity.Role;
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
