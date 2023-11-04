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

//    public void setActiveNavigationButton(Model model, HttpServletRequest request) {
//        String currentPath = request.getRequestURI();
//        if (currentPath.equals("/")) {
//            model.addAttribute("currentPage", "home");
//        } else if (currentPath.equals("/about")) {
//            model.addAttribute("currentPage", "about");
//        } else if (currentPath.equals("/services")) {
//            model.addAttribute("currentPage", "services");
//        } else if (currentPath.equals("/gallery")) {
//            model.addAttribute("currentPage", "gallery");
//        } else if (currentPath.equals("/contact")) {
//            model.addAttribute("currentPage", "contact");
//        }
//    }
}
