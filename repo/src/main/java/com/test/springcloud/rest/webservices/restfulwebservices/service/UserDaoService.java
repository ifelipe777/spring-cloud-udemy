package com.test.springcloud.rest.webservices.restfulwebservices.service;

import com.test.springcloud.rest.webservices.restfulwebservices.bean.User;
import com.test.springcloud.rest.webservices.restfulwebservices.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    @Autowired
    private JpaUserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(final User user) {
        return userRepository.save(user);
    }

    public Optional<User> findOne(final Integer id) {
        return userRepository.findById(id);
    }

    public Boolean deleteById(final Integer id) {
        try {
            userRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
