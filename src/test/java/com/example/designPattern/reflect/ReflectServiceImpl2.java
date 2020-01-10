package com.example.designPattern.reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {
    private String name;
    private int age;

    public ReflectServiceImpl2(String name){
        this.name=name;
    }

    public ReflectServiceImpl2(String name,int age){
        this.name=name;
        this.age=age;
    }

    private void sayHello(){
        System.out.println("Hello "+name);
    }

    private void sayHelloAge(){
        System.out.println("Hello "+name+" Age "+age);
    }

    /**
     * 反射无参构造
     * @return
     */
    public static ReflectServiceImpl2 getInstance(String name){
        ReflectServiceImpl2 object=null;
        try {
            object=(ReflectServiceImpl2)Class.forName("com.example.designPattern.reflect.ReflectServiceImpl2")
                .getConstructor(String.class).newInstance(name);
        }catch (ClassNotFoundException e ){
            e.printStackTrace();
        }catch (IllegalAccessException e ){
            e.printStackTrace();
        }catch (InstantiationException e ){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){

        }
        return object;
    }

    /**
     * 反射无参构造
     * @return
     */
    public static ReflectServiceImpl2 getInstance(String name,int age){
        ReflectServiceImpl2 object=null;
        try {
            object=(ReflectServiceImpl2)Class.forName("com.example.designPattern.reflect.ReflectServiceImpl2")
                    .getConstructor(String.class,int.class).newInstance(name,age);
        }catch (ClassNotFoundException e ){
            e.printStackTrace();
        }catch (IllegalAccessException e ){
            e.printStackTrace();
        }catch (InstantiationException e ){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){

        }
        return object;
    }

    public static void main(String[] args){
        getInstance("张三").sayHello();
        getInstance("张三",18).sayHelloAge();
    }
}
