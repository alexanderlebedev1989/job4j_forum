package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegControl {

    private PostService service;

    public RegControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute User user, Model model) {
        if (service.checkReg(user.getLogin(), user.getPassword())) {
            service.save(user);
            return "redirect:/login";
        } else {
            String errorMessage = "Enter login and password!";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        }


    }
}
