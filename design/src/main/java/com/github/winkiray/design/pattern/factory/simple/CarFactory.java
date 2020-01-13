package com.github.winkiray.design.pattern.factory.simple;

public class CarFactory {

    public Car createCar(String carName){
        if("POLICE".equals(carName)){
            return new PoliceCar();
        }
        return new JeepCar();
    }
}
