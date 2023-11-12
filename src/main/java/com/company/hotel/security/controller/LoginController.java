package com.company.hotel.security.controller;

import com.company.hotel.security.dto.UserDTO;
import com.company.hotel.security.service.UserServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa jest odpowiedzialna za logowanie do systemu poprzez formularz logowania i obsługę nieprawidłowych logowań.
 */

@Controller
public class LoginController {

    @Autowired
    private UserServiceView userService;

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(name = "loginError", required = false) String loginError) {
        model.addAttribute("loginError", loginError);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    //BindingResult must be placed just after @ModelAttribute.
    @PostMapping("/saveUser")
    public String register(@ModelAttribute @Valid UserDTO userDTO,
                           BindingResult bindingResult,
                           @RequestParam("repeatPassword") String repeatPassword,
                           Model model) {
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
