package com.example.designPattern.proxy.jdkProxy;

public class JdkProxyTest {

    public static void main(String[] args){
        JdkProxyExample jdkProxy=new JdkProxyExample(new HelloWorldImpl());
        HelloWordService proxy=jdkProxy.getProxy();
        proxy.sayHelloWorld();
    }
}
