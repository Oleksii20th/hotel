package com.company.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Klasa służąca do ustalenia aktywnego(zaznaczającego) przycisku nawigacyjnego w headerze
 */

@Controller
public class HeaderController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("currentPage", "index");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("currentPage", "about");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("currentPage", "contact");
        return "contact";
    }

    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("currentPage", "gallery");
        return "gallery";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("currentPage", "services");
        return "services";
    }
}
