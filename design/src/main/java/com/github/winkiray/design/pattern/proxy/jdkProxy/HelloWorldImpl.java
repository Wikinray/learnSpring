package com.github.winkiray.design.pattern.proxy.jdkProxy;

public class HelloWorldImpl implements HelloWordService{
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
