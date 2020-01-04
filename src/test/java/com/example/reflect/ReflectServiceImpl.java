package com.example.reflect;

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


    public static void main(String[] args){
        getInstance().sayHello("1111");
    }
}
