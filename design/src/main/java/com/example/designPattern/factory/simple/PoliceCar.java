package com.example.designPattern.factory.simple;

public class PoliceCar implements Car {
    @Override
    public void work() {
        System.out.println("警察车");
    }
}
