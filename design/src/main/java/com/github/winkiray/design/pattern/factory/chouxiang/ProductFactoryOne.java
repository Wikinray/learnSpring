package com.github.winkiray.design.pattern.factory.chouxiang;

public class ProductFactoryOne implements  IProductFactory{

    @Override
    public IProduct createProduct(String productNo) {
        IProduct product=new Banana();
        return product;
    }
}
