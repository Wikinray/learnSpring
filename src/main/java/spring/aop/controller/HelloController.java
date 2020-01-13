package spring.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/spring/aop")
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(){

        return "hello world";
    }
}
