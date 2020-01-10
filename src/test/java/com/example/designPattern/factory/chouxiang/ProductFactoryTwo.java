package com.example.designPattern.factory.chouxiang;

public class ProductFactoryTwo implements  IProductFactory{
    
    @Override
    public IProduct createProduct(String productNo) {
        IProduct product=new Apple();
        return product;
    }
}
