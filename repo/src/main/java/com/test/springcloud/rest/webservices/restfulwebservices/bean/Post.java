package com.test.springcloud.rest.webservices.restfulwebservices.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Post {

   private Integer id;
   private String description;
   private User user;

}
