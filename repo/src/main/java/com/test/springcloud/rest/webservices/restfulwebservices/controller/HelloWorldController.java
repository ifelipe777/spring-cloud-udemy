package com.test.springcloud.rest.webservices.restfulwebservices.controller;

import com.test.springcloud.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

   @GetMapping(path = "/hello-world")
   public String helloWorld(){
      return "hello world!!";
   }

   @GetMapping(path = "/hello-world-bean")
   public HelloWorldBean helloWorldBean(){
      return new HelloWorldBean("hello world!!");
   }

   @GetMapping(path = "/hello-world/path-variable/{name}")
   public HelloWorldBean helloWorldBean(@PathVariable final String name){
      return new HelloWorldBean(String.format("hello world %s", name));
   }
}
