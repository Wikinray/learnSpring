package com.example.proxy.intercept;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkPoxy implements InvocationHandler {

    //真实对象
    private Object target;
    //连接器全限定名
    private String interceptorClass;

    public InterceptorJdkPoxy(Object target,String interceptorClass){
        this.target=target;
        this.interceptorClass=interceptorClass;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(null==interceptorClass){
            //未设置拦截器，反射原方法
            return method.invoke(target,args);
        }
        Object result=null;
        //反射生成拦截器
        Interceptor interceptor=(Interceptor)Class.forName(interceptorClass).newInstance();
        //调用前置方法
        if(interceptor.before(proxy,target,method,args)){
            //反射原有方法
            result=method.invoke(target,args);
        }else{
            //调用around方法
            interceptor.around(proxy,target,method,args);
        }
        //调用后置方法
        interceptor.after(proxy,target,method,args);
        return result;
    }
}
