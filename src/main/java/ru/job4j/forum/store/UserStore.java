package ru.job4j.forum.store;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserStore {

    private Map<String, User> users = new HashMap<>();
    private AtomicInteger count = new AtomicInteger(2);

    public UserStore() {
        User user = User.of("root", "12345");
        user.setId(1);
        users.put("root", user);
    }

    public void save(User user) {
        user.setId(count.incrementAndGet());
        users.put(user.getUsername(), user);
    }

    public boolean checkReg(String name, String password) {
        return !name.equals("") && !password.equals("");
    }

    public boolean checkLogin(String name, String password) {
        User user = users.get(name);
        return user.getUsername().equals(name) && user.getPassword().equals(password);
    }
}
