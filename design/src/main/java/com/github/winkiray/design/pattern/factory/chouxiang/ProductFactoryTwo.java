package com.github.winkiray.design.pattern.factory.chouxiang;

public class ProductFactoryTwo implements  IProductFactory{
    
    @Override
    public IProduct createProduct(String productNo) {
        IProduct product=new Apple();
        return product;
    }
}
