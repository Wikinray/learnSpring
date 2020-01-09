package com.example.proxy.jdkProxy;

public class HelloWorldImpl implements HelloWordService{
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
