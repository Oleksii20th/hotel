package com.company.hotel.security.service.implementation;

import com.company.hotel.security.dto.UserDTO;
import com.company.hotel.security.service.AuthenticationService;
import com.company.hotel.security.service.JwtService;
import com.company.hotel.security.service.UserServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserServiceView userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String registerNewUser(UserDTO userDTO, BindingResult bindingResult, String repeatPassword, Model model) {

        if (userService.existsByUsername(userDTO.getUsername())) {
            bindingResult.rejectValue("username", "error.usernameAlreadyExist", "Username is already exists");
        }

        if (userService.existsByEmail(userDTO.getEmail())) {
            bindingResult.rejectValue("email", "error.emailAlreadyExist", "Email is already exists");
        }

        model.addAttribute("userDTO", userDTO);
        List<String> errorMessages = new ArrayList<>();

        if (!userDTO.getPassword().equals(repeatPassword)) {
            bindingResult.rejectValue("password", "error.passwordMismatch", "Passwords do not match");
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            model.addAttribute("registrationErrors", errorMessages);
            return "register";
        }

        userService.save(userDTO);
        return "redirect:/register";
    }

}
