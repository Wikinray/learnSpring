package com.example.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class XmlDemo {

    SqlSessionFactory sqlSessionFactory=null;
    String resource="mybatis-config.xml";
    InputStream inputStream;


    private SqlSessionFactory getSqlSessionFactory(){
        try {
            inputStream= Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            sqlSessionFactory=builder.build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }


    private void selectOnly(){

        SqlSession sqlSession=null;
        try {
            sqlSession=sqlSessionFactory.openSession();
            /**
             * do something
             */
            sqlSession.commit();
        }catch (Exception e){
            if(null!=sqlSession) {
                sqlSession.rollback();
            }
        }finally {
            if(null!=sqlSession){
                sqlSession.close();
            }
        }
    }


    public static void main(String[] args){

    }
}
