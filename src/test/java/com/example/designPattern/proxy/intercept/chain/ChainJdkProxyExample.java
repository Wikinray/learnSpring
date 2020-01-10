package com.example.designPattern.proxy.intercept.chain;

import com.example.designPattern.proxy.intercept.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ChainJdkProxyExample implements InvocationHandler {

    private Object target;

    private String interceptClass;

    public ChainJdkProxyExample(Object target,String interceptClass){
        this.interceptClass=interceptClass;
        this.target=target;

    }

    public static Object getProxy(Object target,String interceptClass){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new ChainJdkProxyExample(target,interceptClass));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        if(null==interceptClass){
            result=method.invoke(target,args);
        }
        Interceptor interceptor=(Interceptor)Class.forName(interceptClass).newInstance();
        if(interceptor.before(proxy,target,method,args)){
            result=method.invoke(target,args);
        }else{
            interceptor.around(proxy,target,method,args);
        }
        interceptor.after(proxy,target,method,args);
        return result;
    }
}
