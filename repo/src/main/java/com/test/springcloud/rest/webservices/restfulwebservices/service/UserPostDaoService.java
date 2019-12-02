package com.test.springcloud.rest.webservices.restfulwebservices.service;

import com.test.springcloud.rest.webservices.restfulwebservices.bean.Post;
import com.test.springcloud.rest.webservices.restfulwebservices.bean.User;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserPostDaoService {

   public static List<Post> userPosts = new ArrayList<>();

   static {
      User user1 = new User(1, "Adam", new Date());
      User user2 = new User(2, "Eve", new Date());
      User user3 = new User(3, "Jack", new Date());
      userPosts.add(new Post(1, "description 1 user 1", user1));
      userPosts.add(new Post(2, "description 2 user 1", user1));
      userPosts.add(new Post(3, "description 3 user 1", user1));
      userPosts.add(new Post(4, "description 1 user 2", user2));
      userPosts.add(new Post(5, "description 1 user 3", user3));
   }

   public List<Post> findAll() {
      return userPosts;
   }

   public List<Post> findAllByUser(final Integer userId) {
      return userPosts.stream().filter(p -> p.getUser().getId().equals(userId)).collect(Collectors.toList());
   }

   public Optional<Post> findByUserAndPostId(final Integer userId, final Integer postId) {
      return userPosts.stream().filter(p -> p.getUser().getId().equals(userId))
            .collect(Collectors.toList())
            .stream().filter(up -> up.getId().equals(postId)).findAny();
   }

   public Post save (final Post post) {
      if(Objects.isNull(post.getId())){
         post.setId(userPosts.size() + 1);
      }
      userPosts.add(post);
      return post;
   }
}
