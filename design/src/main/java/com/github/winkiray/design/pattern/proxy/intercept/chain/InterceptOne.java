package com.github.winkiray.design.pattern.proxy.intercept.chain;

import com.example.designPattern.proxy.intercept.Interceptor;

import java.lang.reflect.Method;

public class InterceptOne implements Interceptor {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】 before方法");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】 around方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】 after方法");
    }
}
