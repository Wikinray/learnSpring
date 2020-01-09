package com.example.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {
    private void sayHello(String name){
        System.out.println("Hello "+name);
    }

    /**
     * 反射无参构造
     * @return
     */
    public static ReflectServiceImpl getInstance(){
        ReflectServiceImpl object=null;
        try {
            object=(ReflectServiceImpl)Class.forName("com.example.reflect.ReflectServiceImpl").newInstance();
        }catch (ClassNotFoundException e ){
            e.printStackTrace();
        }catch (IllegalAccessException e ){
            e.printStackTrace();
        }catch (InstantiationException e ){
            e.printStackTrace();
        }
        return object;
    }

    private static Object reflectMethod(ReflectServiceImpl target){
        Object returnObject=null;
        try {
            Method method=target.getClass().getDeclaredMethod("sayHello",String.class);
            returnObject= method.invoke(target,"2222");
        }catch (InvocationTargetException e){

        }catch (IllegalAccessException e){

        }catch (NoSuchMethodException e){

        }
        return returnObject;
    }


    public static void main(String[] args){
        ReflectServiceImpl target=getInstance();
        target.sayHello("1111");

        reflectMethod(target);
    }
}
