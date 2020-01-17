package com.example.mybatis.utils.dataSourceFactory;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DbcpDataSourceFactory implements DataSourceFactory {
    private Properties properties;

    @Override
    public void setProperties(Properties props) {
        this.properties=props;
    }

    @Override
    public DataSource getDataSource() {
        DataSource dataSource=null;
        try {
            dataSource=BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }
}
