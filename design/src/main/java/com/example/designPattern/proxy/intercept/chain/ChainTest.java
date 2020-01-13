package com.example.designPattern.proxy.intercept.chain;

public class ChainTest {

    public static void main(String[] args){

        HolidayService proxy1=(HolidayService)ChainJdkProxyExample.getProxy(new HolidayImpl(),"com.example.designPattern.proxy.intercept.chain.InterceptOne");

        HolidayService proxy2=(HolidayService)ChainJdkProxyExample.getProxy(proxy1,"com.example.designPattern.proxy.intercept.chain.InterceptTwo");

        HolidayService proxy3=(HolidayService)ChainJdkProxyExample.getProxy(proxy2,"com.example.designPattern.proxy.intercept.chain.InterceptThree");

        proxy3.audit();
    }
}
