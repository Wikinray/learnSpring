package com.github.winkiray.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {

    //产品列表
    private List<String> productList=null;

    private static ProductList instance=null;

    private ProductList(List<String> productList){
        this.productList=productList;
    }

    public static ProductList getInstance(){
        if(null==instance){
            instance=new ProductList(new ArrayList<>());
        }
        return instance;
    }


    public void addProductObserver(Observer observer){
        this.addObserver(observer);
    }

    public void addProduct(String product){
        System.out.println("产品列表新增了产品 ：" + product);
        productList.add(product);
        this.setChanged();
        this.notifyObservers(product);
    }

}
