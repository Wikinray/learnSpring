package com.example.observer;

public class ObserverTest {

    public static void main(String[] args){
        ProductList observable=ProductList.getInstance();


        observable.addProductObserver(new JdObserver());
        observable.addProductObserver(new TbObserver());

        observable.addProduct("自行车");
    }

}
