package com.company.hotel.security.controller;

import com.company.hotel.security.service.UserServiceViewImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Klasa jest odpowiedzialna za logowanie do systemu poprzez formularz logowania i obsługę nieprawidłowych logowań.
 */

@Controller
public class LoginController {

    @Autowired
    private UserServiceViewImpl userService;

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(name = "loginError", required = false) String loginError) {
        model.addAttribute("loginError", loginError);
        return "login";
    }

}
