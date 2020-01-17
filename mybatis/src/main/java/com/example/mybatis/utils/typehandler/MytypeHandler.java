package com.example.mybatis.utils.typehandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
//指定javaType
@MappedTypes(String.class)
//指定jdbcType
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MytypeHandler implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        log.info("设置string参数【"+parameter+"】");
        ps.setString(i,parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        String result=rs.getString(columnName);
        log.info("读取string参数1【"+result+"】");
        return result;
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        String result=rs.getString(columnIndex);
        log.info("读取string参数2【"+result+"】");
        return result;
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result=cs.getString(columnIndex);
        log.info("读取string参数3【"+result+"】");
        return result;
    }
}
