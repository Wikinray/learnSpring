package com.example.designPattern.proxy.jdkProxy;

public class HelloWorldImpl implements HelloWordService{
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
