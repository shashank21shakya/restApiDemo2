package com.yash.restApiDemo1.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloWorldCallableController {
	
	  @GetMapping(value = "/testCallable")
      public Callable<String> echoHelloWorld()
      {
            return () ->
            {
                  Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
                   
                  return "Hello World !!";
            };
      }

}
