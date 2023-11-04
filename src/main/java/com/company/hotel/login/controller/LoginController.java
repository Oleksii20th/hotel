package com.company.hotel.login.controller;

import com.company.hotel.login.dto.UserDTO;
import com.company.hotel.login.service.UserServiceViewImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Klasa jest odpowiedzialna za logowanie do systemu poprzez formularz logowania i obsługę nieprawidłowych logowań.
 */

@Controller
public class LoginController {

    @Autowired
    private UserServiceViewImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(@RequestParam(name = "loginError", required = false) String loginError, Model model) {
        model.addAttribute("loginError", loginError);
        return "login";
    }

    @PostMapping("/loginSubmit")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
        UserDTO user = userService.getUserDtoByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "redirect:/hotel";
        } else {
            model.addAttribute("loginError", "authentication");
            return "login";
        }
    }
}
