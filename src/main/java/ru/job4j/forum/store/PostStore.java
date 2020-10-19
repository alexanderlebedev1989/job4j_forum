package ru.job4j.forum.store;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostStore {

    private Map<Integer, Post> posts = new HashMap<>();
    private AtomicInteger idPost = new AtomicInteger(3);
    private AtomicInteger idComment = new AtomicInteger(1);


    public PostStore() {
        posts.put(1, Post.of(1, "Зарплаты программистов Java", Calendar.getInstance()));
        posts.put(2, Post.of(2, "Требования к Junior программисту", Calendar.getInstance()));
    }

    public void save(Post post) {
        post.setId(idPost.incrementAndGet());
        post.setCreated(Calendar.getInstance());
        posts.put(post.getId(), post);
    }

    public void update(String name, String desc, int id) {
        Post post = findBiId(id);
        post.setName(name);
        post.setDescription(desc);
        posts.put(post.getId(), post);
    }

    public Post findBiId(int id) {
        return posts.get(id);
    }

    public Collection<Post> getAllPosts() {
        return posts.values();
    }

    public void delete(int id) {
        posts.remove(id);
    }

    public void saveComment(int id, Comment comment) {
       Post post = findBiId(id);
       comment.setId(idComment.incrementAndGet());
       comment.setCalendar(Calendar.getInstance());
       post.addComment(comment);
    }

    public void deleteComment(int idComm, int idPost) {
        Comment result = null;
        Post post = findBiId(idPost);
        for (Comment comment : post.getComments()) {
            if (comment.getId() == idComm) {
                result = comment;
            }
        }
        post.getComments().remove(result);
    }

}
