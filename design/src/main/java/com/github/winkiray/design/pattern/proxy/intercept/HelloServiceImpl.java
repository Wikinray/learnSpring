package com.github.winkiray.design.pattern.proxy.intercept;

public class HelloServiceImpl implements HelloService{

    @Override
    public void say(){
        System.out.println("测试interceptor");
    }
}
