package com.example.designPattern.proxy.intercept.chain;

public class HolidayImpl implements HolidayService{

    @Override
    public void audit() {
        System.out.println("请假审核");
    }
}
