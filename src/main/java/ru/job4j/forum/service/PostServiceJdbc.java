package ru.job4j.forum.service;

import org.springframework.stereotype.Service;

import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.CommentRepository;
import ru.job4j.forum.store.PostRepository;
import ru.job4j.forum.store.UserRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Service
public class PostServiceJdbc {

    private PostRepository posts;
    private CommentRepository comments;
    private UserRepository users;

    public PostServiceJdbc(PostRepository posts,
                           CommentRepository comments,
                           UserRepository users) {
        this.posts = posts;
        this.comments = comments;
        this.users = users;

    }

    public void savePost(Post post) {
        post.setCreated(Calendar.getInstance());
        posts.save(post);
    }

    public Post findByIdPost(int id) {
        Post post = posts.findById(id).get();
        List<Comment> list = findByPostId(post.getId());
        post.setComments(list);
        return post;
    }

    public void deletePost(int id) {
        List<Comment> list = findByPostId(id);
        comments.deleteAll(list);
        posts.deleteById(id);
    }

    public Collection<Post> getAllPosts() {
        List<Post> list = new ArrayList<>();
        posts.findAll().forEach(list::add);
        return list;
    }

    public List<Comment> findByPostId(int postId) {
        return comments.findByPostId(postId);
    }

    public Comment findByIdComment(int idComm) {
        return comments.findById(idComm).get();
    }

    public void saveComment(Comment comment) {
        comments.save(comment);
    }

    public void deleteComment(int idComm, int idPost) {
        Post post = findByIdPost(idPost);
        Comment comment = findByIdComment(idComm);
        post.getComments().remove(comment);
        comments.delete(comment);
    }

    public void saveUser(User user) {
        users.save(user);
    }
    public User findByNameAndPassword(String login, String password) {
        return users.findByNameAndPassword(login, password);
    }

    public boolean checkReg(String name, String password) {
        return !name.equals("") && !password.equals("");
    }
}
