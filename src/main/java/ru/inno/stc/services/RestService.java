package ru.inno.stc.services;

import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.stc.model.User;

@RestController
public class RestService {

    private final UserService service;

    @Autowired
    public RestService(UserService service) {
        this.service = service;
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return service.getUser(id);
    }

    @RequestMapping("/delete/{id}")
    public User deleteUser(@PathVariable("id") Integer id) {
        return service.deleteUser(id);
    }

    @RequestMapping("/{id}/{name}")
    public User updateUserName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return service.updateUserName(id, name);
    }

    @RequestMapping("/update/{id}/{name}")
    public User updateUser(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        final User user = service.getUser(id);
        user.setName(name);
        return service.updateUser(user);
    }

}
