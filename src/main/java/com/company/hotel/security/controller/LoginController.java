package com.company.hotel.security.controller;

import com.company.hotel.security.dto.UserDTO;
import com.company.hotel.security.service.UserServiceViewImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Klasa jest odpowiedzialna za logowanie do systemu poprzez formularz logowania i obsługę nieprawidłowych logowań.
 */

@Controller
public class LoginController {

    @Autowired
    private UserServiceViewImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(name = "loginError", required = false) String loginError) {
        model.addAttribute("loginError", loginError);
        return "login";
    }

    @PostMapping("/loginSubmit")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {
        UserDTO user = userService.getUserDtoByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/";
        } else {
            model.addAttribute("loginError", "authentication");
            return "redirect:/login";
        }
    }

    @PatchMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestParam String username,
                                            @RequestParam String currentPassword,
                                            @RequestParam String newPassword,
                                            @RequestParam String confirmationPassword,
                                            Model model) {
        try {
            userService.changePassword(username, currentPassword, newPassword, confirmationPassword);
        } catch (IllegalArgumentException error) {
            model.addAttribute("changePasswordError", error.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
