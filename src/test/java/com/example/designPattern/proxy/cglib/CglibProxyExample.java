package com.example.designPattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {


    public Object getProxy(Class c){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }



    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.err.println("调用真实对象前");
        methodProxy.invokeSuper(proxy,args);
        System.err.println("调用真实对象后");
        return null;
    }
}
