package com.company.hotel.security.service;

import com.company.hotel.security.dto.UserDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface AuthenticationService {

    String registerNewUser(UserDTO userDTO, BindingResult bindingResult, String repeatPassword, Model model);

}
