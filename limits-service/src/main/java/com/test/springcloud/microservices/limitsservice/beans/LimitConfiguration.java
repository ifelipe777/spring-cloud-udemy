package com.test.springcloud.microservices.limitsservice.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LimitConfiguration {
   private int minimum;
   private int maximum;
}
