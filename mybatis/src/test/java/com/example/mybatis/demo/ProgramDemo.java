package com.example.mybatis.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.mapper.BossUserMapper;
import com.example.mybatis.mapper.BossUserMapper2;
import com.example.mybatis.model.BossUser;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.InputStream;
import java.util.Properties;

public class ProgramDemo {

    private SqlSessionFactory getSqlSessionFactory(){
        SqlSessionFactory sqlSessionFactory=null;
        try {
            //数据库连接池信息
            PooledDataSource dataSource=new PooledDataSource();
            dataSource.setDriver("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://192.168.1.164:3306/seventeen");
            dataSource.setUsername("jindi");
            dataSource.setPassword("jindi");
            dataSource.setDefaultAutoCommit(false);

            //采用jdbc事务方式
            TransactionFactory transactionFactory=new JdbcTransactionFactory();

            Environment environment=new Environment("development",transactionFactory,dataSource);

            //创建Configuration对象
            Configuration configuration=new Configuration();
            configuration.setEnvironment(environment);

            configuration.getTypeAliasRegistry().registerAlias("bossUser", BossUser.class);
            configuration.addMapper(BossUserMapper2.class);

            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            sqlSessionFactory=builder.build(configuration);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    private SqlSessionFactory getSqlSessionFactory3(){
        SqlSessionFactory sqlSessionFactory=null;
        try {
            InputStream proInputStream =Resources.getResourceAsStream("jdbc.properties");

            Properties properties=new Properties();
            properties.load(proInputStream);
            String userName=properties.getProperty("database.username");
            String password=properties.getProperty("database.password");
            /**
             * 处理userName password  进行解密
             */
            properties.setProperty("database.username",userName);
            properties.setProperty("database.password",password);


            InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            sqlSessionFactory=builder.build(inputStream,properties);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    private SqlSessionFactory getSqlSessionFactory2(){
        SqlSessionFactory sqlSessionFactory=null;
        try {
            sqlSessionFactory= SqlSessionManager.newInstance(getSqlSessionFactory());
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }


    private void selectOnly(SqlSessionFactory sqlSessionFactory){

        SqlSession sqlSession=null;
        try {
            sqlSessionFactory=getSqlSessionFactory();
            //打开会话
            sqlSession=sqlSessionFactory.openSession();
            /**
             * do something
             */
            BossUser bossUser=(BossUser)sqlSession.selectOne("com.example.mybatis.mapper.BossUserMapper2.getBossUser2","20190927C06627184133176557568");
            //BossUser bossUser=(BossUser)sqlSession.selectOne("getBossUser2","1");
            System.out.println("结果："+ JSONObject.toJSONString(bossUser));

            BossUserMapper2 mapper2=sqlSession.getMapper(BossUserMapper2.class);
            BossUser bossUser2=mapper2.getBossUser2("20190927C06627184133176557568");

            System.out.println("结果2："+ JSONObject.toJSONString(bossUser2));
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            if(null!=sqlSession) {
                //回滚事务
                sqlSession.rollback();
            }
        }finally {
            //关闭，释放资源
            if(null!=sqlSession){
                sqlSession.close();
            }
        }
    }

    public static void main(String[] args){
        ProgramDemo programDemo=new ProgramDemo();
        //SqlSessionFactory sqlSessionFactory=programDemo.getSqlSessionFactory();
        SqlSessionFactory sqlSessionFactory=programDemo.getSqlSessionFactory2();
        programDemo.selectOnly(sqlSessionFactory);
    }
}
