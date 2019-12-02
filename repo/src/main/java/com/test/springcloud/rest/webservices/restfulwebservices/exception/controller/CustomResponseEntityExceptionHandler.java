package com.test.springcloud.rest.webservices.restfulwebservices.exception.controller;

import com.test.springcloud.rest.webservices.restfulwebservices.exception.ExceptionResponse;
import com.test.springcloud.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.test.springcloud.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(Exception.class)
   public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest wr) {
      ExceptionResponse exceptionResponse =
            new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));

      return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   @ExceptionHandler({UserNotFoundException.class, PostNotFoundException.class})
   public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest wr) {
      ExceptionResponse exceptionResponse =
            new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));

      return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
   }

}
