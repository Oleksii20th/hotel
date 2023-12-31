package com.company.hotel.security.dto;

import com.company.hotel.security.entity.Role;
import com.company.hotel.security.validator.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    private long id;

    @NotBlank(message = "The field can't be empty.")
    private String username;

    @NotBlank(message = "The field email can't be empty.")
    @ValidEmail
    private String email;

    @NotBlank(message = "The field password can't be empty.")
    @Size(min = 4, message = "The field must be more than 4 characters")
    private String password;

    private Role roles;

}