package com.test.springcloud.rest.webservices.restfulwebservices.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {

   @Id
   @GeneratedValue
   private Integer id;
   private String description;
   @ManyToOne(fetch = FetchType.LAZY)
   @JsonIgnore
   private User user;

}
