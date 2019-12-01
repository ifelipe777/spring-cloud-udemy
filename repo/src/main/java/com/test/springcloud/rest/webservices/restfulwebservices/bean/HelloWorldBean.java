package com.test.springcloud.rest.webservices.restfulwebservices.bean;

public class HelloWorldBean {

   private String message;

   public HelloWorldBean(final String message) {
      this.message = message;
   }

   public String getMessage(){
      return this.message;
   }

}
