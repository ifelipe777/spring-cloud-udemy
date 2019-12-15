package com.test.springcloud.rest.webservices.restfulwebservices.service;

import com.sun.tools.javac.util.ArrayUtils;
import com.test.springcloud.rest.webservices.restfulwebservices.bean.Post;
import com.test.springcloud.rest.webservices.restfulwebservices.bean.User;
import com.test.springcloud.rest.webservices.restfulwebservices.repository.JpaPostRepository;
import com.test.springcloud.rest.webservices.restfulwebservices.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class UserPostDaoService {

   @Autowired
   private JpaPostRepository postRepository;

   @Autowired
   private JpaUserRepository userRepository;

   public List<Post> findAll() {
      return postRepository.findAll();
   }

   public List<Post> findAllByUser(final Integer userId) {
      Optional<User> optUser = userRepository.findById(userId);
      if(optUser.isPresent()){
         User user = optUser.get();
         return user.getPosts();
      } else {
         return Collections.emptyList();
      }
   }

   public Optional<Post> findByUserAndPostId(final Integer userId, final Integer postId) {
      return postRepository.findPostByIdAndUser_Id(postId, userId);
   }

   public Post save (final Post post) {
      return postRepository.save(post);
   }
}
