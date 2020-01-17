package com.example.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFatoryUtils {

    private final static Class<SqlSessionFatoryUtils> LOCK=SqlSessionFatoryUtils.class;

    private static SqlSessionFactory sqlSessionFactory=null;

    private static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK){
            if(null!=sqlSessionFactory){
                return sqlSessionFactory;
            }
            InputStream inputStream;
            try {
                String resource="mapper/mybatis-config.xml";
                inputStream= Resources.getResourceAsStream(resource);
                sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
            }catch (IOException e){
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSession(){
        if(null==sqlSessionFactory){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
