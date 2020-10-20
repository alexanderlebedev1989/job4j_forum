package ru.job4j.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostServiceJdbc;

@Controller
public class PostControl {

    private PostServiceJdbc service;

    public PostControl(PostServiceJdbc service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "forum/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Post post) {
        service.savePost(post);
        return "redirect:/index";
    }

    @GetMapping("/post")
    public String post(@RequestParam("id") int id, Model model) {
        Post post = service.findByIdPost(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", post.getComments());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post";

    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Post post = service.findByIdPost(id);
        model.addAttribute("post", post);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "forum/edit";

    }

    @PostMapping("/edit")
    public String edit(@RequestParam("name") String name,
                       @RequestParam("description") String desc,
                       @RequestParam("id") int id) {
        Post post = service.findByIdPost(id);
        post.setName(name);
        post.setDescription(desc);
        service.savePost(post);
        return "redirect:/post?id=" + id;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        service.deletePost(id);
        return "redirect:/index";
    }

    @PostMapping("/addComment")
    public String addComment(@ModelAttribute Comment comment,
                             @RequestParam("id") int id) {
        Post post = service.findByIdPost(id);
        post.addComment(comment);
        comment.setPost(post);
        service.saveComment(comment);
        return "redirect:/post?id=" + id;
    }

    @GetMapping("/deleteComment")
    public String deleteComment(@RequestParam("idComm") int idComm,
                                @RequestParam("idPost") int idPost) {
        service.deleteComment(idComm, idPost);
        return "redirect:/post?id=" + idPost;
    }
}




