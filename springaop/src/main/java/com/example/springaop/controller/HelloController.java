package com.example.springaop.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/spring/aop")
@RestController
public class HelloController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String userName){

        return "hello"+userName;
    }
}
