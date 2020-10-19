package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostServiceJdbc;

@Controller
public class RegControl {

    private PostServiceJdbc service;

    public RegControl(PostServiceJdbc service) {
        this.service = service;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute User user, Model model) {
        if (service.checkReg(user.getName(), user.getPassword())) {
            service.saveUser(user);
            return "redirect:/";
        } else {
            String errorMessage = "Enter login and password!";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        }
    }
}
