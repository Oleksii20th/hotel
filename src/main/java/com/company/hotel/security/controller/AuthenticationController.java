package com.company.hotel.security.controller;

import com.company.hotel.security.dto.UserDTO;
import com.company.hotel.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

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

    @PostMapping("/saveUser")
    public String register(@ModelAttribute @Valid UserDTO userDTO,
                           BindingResult bindingResult,
                           @RequestParam("repeatPassword") String repeatPassword,
                           Model model) {
        return authenticationService.registerNewUser(userDTO, bindingResult, repeatPassword, model);
    }
}
