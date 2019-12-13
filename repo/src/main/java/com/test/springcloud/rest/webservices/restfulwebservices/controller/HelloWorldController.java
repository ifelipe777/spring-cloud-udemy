package com.test.springcloud.rest.webservices.restfulwebservices.controller;

import com.test.springcloud.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

   @Autowired
   private MessageSource messageSource;

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

   @GetMapping(path = "/hello-world-internationalized")
   public String helloWorldInternationalized(){
      return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
   }
}
