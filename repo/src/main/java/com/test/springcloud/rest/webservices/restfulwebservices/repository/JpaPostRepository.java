package com.test.springcloud.rest.webservices.restfulwebservices.repository;

import com.test.springcloud.rest.webservices.restfulwebservices.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPostRepository extends JpaRepository<Post, Integer> {

    Optional<Post> findPostByIdAndUser_Id(final Integer postId, final Integer userId);
}
