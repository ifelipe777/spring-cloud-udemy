package com.test.springcloud.microservices.limitsservice.controller;

import com.test.springcloud.microservices.limitsservice.Configuration;
import com.test.springcloud.microservices.limitsservice.beans.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

   @Autowired
   private Configuration configuration;

   @GetMapping("/limits")
   public LimitConfiguration retrieveLimitsFromConfiguration() {
      return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
   }
}
