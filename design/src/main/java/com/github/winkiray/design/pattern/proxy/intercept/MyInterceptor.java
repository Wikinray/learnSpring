package com.github.winkiray.design.pattern.proxy.intercept;

import java.lang.reflect.Method;
import java.util.Random;

public class MyInterceptor implements Interceptor{

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println ("反射方法前逻辑");
        return new Random().nextInt(10)>5;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println ("取代了被代理对象的逻辑");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println ("反射方法后逻辑");
    }

}
