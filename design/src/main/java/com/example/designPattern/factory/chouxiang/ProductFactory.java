package com.example.designPattern.factory.chouxiang;

public class ProductFactory implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        IProductFactory productFactory=null;
        if("ONE".equals(productNo)){
            productFactory=new ProductFactoryOne();
        }else{
            productFactory=new ProductFactoryTwo();
        }
        if(null!=productFactory){
            return productFactory.createProduct(productNo);
        }
        return null;
    }
}
