package com.test.springcloud.rest.webservices.restfulwebservices.controller;

import com.test.springcloud.rest.webservices.restfulwebservices.bean.Post;
import com.test.springcloud.rest.webservices.restfulwebservices.bean.User;
import com.test.springcloud.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.test.springcloud.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.test.springcloud.rest.webservices.restfulwebservices.service.UserDaoService;
import com.test.springcloud.rest.webservices.restfulwebservices.service.UserPostDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private UserPostDaoService userPostDaoService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public Resource<User> retrieveUser(@PathVariable final Integer id) {
        Optional<User> optUser = userDaoService.findOne(id);
        if (!optUser.isPresent()) {
            throw new UserNotFoundException("Id: " + id);
        }

        Resource<User> resource = new Resource<User>(optUser.get());
        ControllerLinkBuilder linkTo =
              ControllerLinkBuilder.linkTo(ControllerLinkBuilder
                    .methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody final User user) {
        User newUser = userDaoService.save(user);
        URI userLocation = ServletUriComponentsBuilder
              .fromCurrentRequest()
              .path("/{id}")
              .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(userLocation).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable final Integer id) {
        if (!userDaoService.deleteById(id)) {
            throw new UserNotFoundException("Id: " + id);
        }
    }

    @GetMapping(path = "/users/{userId}/posts")
    public List<Post> retrieveAllUsersPosts(@PathVariable final Integer userId) {
        return userPostDaoService.findAllByUser(userId);
    }

    @GetMapping(path = "/users/{userId}/posts/{id}")
    public Post retrieveUserPostDetails(@PathVariable final Integer userId,
                                        @PathVariable final Integer id) {
        Optional<Post> optPost = userPostDaoService.findByUserAndPostId(userId, id);
        if (!optPost.isPresent()) {
            throw new PostNotFoundException("user: " + userId + " - id: " + id);
        }

        return optPost.get();
    }

    @PostMapping(path = "/users/{userId}/posts")
    public ResponseEntity<Object> savePost(@PathVariable final Integer userId, @RequestBody final Post post) {
        User user = userDaoService.findOne(userId).get();
        post.setUser(user);
        userPostDaoService.save(post);
        URI userLocation = ServletUriComponentsBuilder
              .fromCurrentRequest()
              .path("/{userId}")
              .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(userLocation).build();

    }
}
