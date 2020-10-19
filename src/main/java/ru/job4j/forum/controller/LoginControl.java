package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.PostServiceJdbc;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginControl {

    private PostServiceJdbc service;

    public LoginControl(PostServiceJdbc service) {
        this.service = service;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password) {
        User user = service.findByNameAndPassword(login, password);
        if (user != null) {
            return "redirect:/index";
        } else {
            return "login";
        }
    }
}
