package ru.inno.stc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.inno.stc.model.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final Map<Integer, User> users = new HashMap<>();

    public UserService() {
        users.put(1, new User(1, "Ivan", "+78899778456"));
        users.put(2, new User(2, "Petr", "+76545465555"));
        users.put(3, new User(3, "Masha", "+79699966554"));
    }

    @Cacheable("users")
    public User getUser(Integer id) {
        final User user = users.get(id);
        if (user != null) {
            logger.info("Found user: {}", user);
        } else {
            logger.info("User with id = {} not found!", id);
        }
        return user;
    }

    @CacheEvict(value = "users", allEntries = true)
    public User deleteUser(Integer id) {
        final User user = users.remove(id);
        if (user != null) {
            logger.info("Remove user: {}", user);
        } else {
            logger.info("User with id = {} not found!", id);
        }
        return user;
    }

    @CachePut(value = "users", condition = "#id==1", key = "#id")
    public User updateUserName(Integer id, String name) {
        User user = users.get(id);
        user.setName(name);
        logger.info("Update user: {}", user);
        return user;
    }


    @CachePut(value = "users", condition = "#user.id==1", key = "#user.id")
    public User updateUser(User user) {
        //final User newUser = users.replace(user.getId(), user);
        logger.info("Update user: {}", user);
        return user;
    }

}
