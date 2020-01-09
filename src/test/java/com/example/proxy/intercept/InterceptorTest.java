package com.example.proxy.intercept;

public class InterceptorTest {
    public static void main(String[] args){

        InterceptorJdkPoxy interceptorJdkPoxy=new InterceptorJdkPoxy(new HelloServiceImpl(),"com.example.proxy.intercept.MyInterceptor");
        HelloService helloService=(HelloService)interceptorJdkPoxy.getProxy();
        helloService.say();
    }
}
