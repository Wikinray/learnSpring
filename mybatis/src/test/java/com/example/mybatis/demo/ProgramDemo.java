package com.example.mybatis.demo;

import com.example.mybatis.mapper.BossUserMapper;
import com.example.mybatis.model.BossUser;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class ProgramDemo {
    SqlSessionFactory sqlSessionFactory=null;



    private SqlSessionFactory getSqlSessionFactory(){
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
            configuration.addMapper(BossUserMapper.class);

            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            sqlSessionFactory=builder.build(configuration);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }


    private void selectOnly(){

        SqlSession sqlSession=null;
        try {
            //打开会话
            sqlSession=sqlSessionFactory.openSession();
            /**
             * do something
             */
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

    }
}
