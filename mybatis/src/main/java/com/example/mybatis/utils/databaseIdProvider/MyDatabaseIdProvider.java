package com.example.mybatis.utils.databaseIdProvider;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MyDatabaseIdProvider implements DatabaseIdProvider {

    private static final String DATABASE_TYPE_DB2="DB2";
    private static final String DATABASE_TYPE_MYSQL="MySQL";
    private static final String DATABASE_TYPE_ORACLE="Oracle";

    @Override
    public void setProperties(Properties p) {
        System.out.println(p);
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {

        Connection connection=dataSource.getConnection();
        String databaseProductName=connection.getMetaData().getDatabaseProductName();

        if(DATABASE_TYPE_DB2.equals(databaseProductName)){
            return "db2";
        }else if(DATABASE_TYPE_MYSQL.equals(databaseProductName)){
            return "mysql";
        }else if(DATABASE_TYPE_ORACLE.equals(databaseProductName)) {
            return "oracle";
        }else{
            return null;
        }

    }
}
