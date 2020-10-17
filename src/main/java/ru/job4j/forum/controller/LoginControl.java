package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.service.PostService;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginControl {

    private PostService service;

    public LoginControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String login(HttpServletRequest request) {
        if (service.checkLogin(request.getParameter("login"),
                request.getParameter("password"))) {
            return "redirect:/index";
        } else {
            return "login";
        }
    }
}
