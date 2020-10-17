package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.PostStore;
import ru.job4j.forum.store.UserStore;

import java.util.Collection;

@Service
public class PostService {

    private PostStore posts;
    private UserStore users;

    public PostService(PostStore posts, UserStore users) {
        this.posts = posts;
        this.users = users;
    }

    public void save(Post post) {
        posts.save(post);
    }

    public void update(String name, String desc, int id) {
        posts.update(name, desc, id);
    }

    public Post findByIdPost(int id) {
        return posts.findBiId(id);
    }

    public void deletePost(int id) {
        posts.delete(id);
    }

    public Collection<Post> getAllPosts() {
        return posts.getAllPosts();
    }

    public void save(User user) {
        users.save(user);
    }

    public void saveComment(int id, Comment comment) {
        posts.saveComment(id, comment);
    }

    public void deleteComment(int idComm, int idPost) {
        posts.deleteComment(idComm, idPost);
    }

    public boolean checkLogin(String name, String password) {
        return users.checkLogin(name, password);
    }

    public boolean checkReg(String name, String password) {
        return users.checkReg(name, password);
    }
}
