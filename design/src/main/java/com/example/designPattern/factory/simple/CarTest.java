package com.example.designPattern.factory.simple;

public class CarTest {

    public static void main(String[] args){
        CarFactory factory=new CarFactory();
        Car car=factory.createCar("POLICE");
        car.work();
    }
}
