package com.example.designPattern.factory.chouxiang;

public class ProductFactoryOne implements  IProductFactory{

    @Override
    public IProduct createProduct(String productNo) {
        IProduct product=new Banana();
        return product;
    }
}
