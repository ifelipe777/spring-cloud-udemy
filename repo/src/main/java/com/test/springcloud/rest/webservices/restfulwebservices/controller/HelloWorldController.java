package com.test.springcloud.rest.webservices.restfulwebservices.controller;

import com.test.springcloud.rest.webservices.restfulwebservices.controller.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
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
}
