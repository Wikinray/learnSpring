package com.example.proxy.cglib;

public class CglibProxyTest {

    public static void main(String[] args){
        CglibProxyExample cglibProxyExample=new CglibProxyExample();

        HelloWorldCg helloWorld=(HelloWorldCg)cglibProxyExample.getProxy(HelloWorldCg.class);
        helloWorld.say();
    }
}
