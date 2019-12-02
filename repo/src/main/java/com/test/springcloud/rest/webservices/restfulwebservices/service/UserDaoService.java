package com.test.springcloud.rest.webservices.restfulwebservices.service;

import com.test.springcloud.rest.webservices.restfulwebservices.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
        users.add(new User(4, "Test", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(final User user) {
        if(Objects.isNull(user.getId())) {
            user.setId(users.size() + 1);
        }
        users.add(user);

        return user;
    }

    public Optional<User> findOne(final Integer id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public Boolean deleteById(final Integer id) {
        return users.removeIf(u -> u.getId().equals(id));
    }
}
