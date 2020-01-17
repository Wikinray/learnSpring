package com.example.mybatis.utils.objectFactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;


/**
 * 如果打断点调试一步步跟进，那么你会发现 MyBatis 创建了一个 List 对象和一个 Role对象。
 * 它会先调用方法 1 ，然后调用方法 2，只是最后生成了同一个对象，所以在写入的判断中，始终返回的是 true。
 * 因为返回的是一个 Role 对象，所以它会最后适配为一个 Role
 * 对象，这就是它的工作过程。
 */
public class MyObjectFactory extends DefaultObjectFactory {

    private static final long serialVersionUID = -888477406461991928L;


    private Object temp=null;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        System.out.println("-----初始化参数【"+properties+"】-----------");
    }

    @Override
    public <T> T create(Class<T> type) {
        T result=super.create(type);
        System.out.println("-----创建对象："+result.toString()+"-----------");
        System.out.println("-----是否和上次创建的是同一对象【"+(temp==result)+"】-----------");
        return result;
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T result = super.create(type,constructorArgTypes,constructorArgs);
        System.out.println("-----创建对象："+result.toString()+"-----------");
        temp=result;
        return result;
    }


    @Override
    public <T> boolean isCollection(Class<T> type) {
        System.out.println("-----isCollection-----------");
        return super.isCollection(type);
    }
}
