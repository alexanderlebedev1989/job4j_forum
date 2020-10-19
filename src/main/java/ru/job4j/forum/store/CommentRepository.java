package ru.job4j.forum.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.job4j.forum.model.Comment;


import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM comments WHERE post_id = ?1", nativeQuery = true)
    List<Comment> findByPostId(int postId);
}
