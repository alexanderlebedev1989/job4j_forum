package ru.job4j.forum.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.forum.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNameAndPassword(String name, String password);
}
