package com.test.springcloud.rest.webservices.restfulwebservices.repository;

import com.test.springcloud.rest.webservices.restfulwebservices.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Integer> {
}
