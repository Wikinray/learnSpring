package com.example.mybatis.utils.typehandler;

import com.example.mybatis.model.enums.UserTypeEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(UserTypeEnum.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class UserEnumTypeHandler implements TypeHandler<UserTypeEnum> {
    @Override
    public void setParameter(PreparedStatement ps, int i, UserTypeEnum parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("设置自定义enum typeHandler");
        ps.setString(i,parameter.getName());
    }

    @Override
    public UserTypeEnum getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("读取自定义enum typeHandler 1");
        String str=rs.getString(columnName);
        return UserTypeEnum.getEnumByName(str);
    }

    @Override
    public UserTypeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("读取自定义enum typeHandler 2");
        String str=rs.getString(columnIndex);
        return UserTypeEnum.getEnumByName(str);
    }

    @Override
    public UserTypeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("读取自定义enum typeHandler 3");
        String str=cs.getString(columnIndex);
        return UserTypeEnum.getEnumByName(str);
    }
}
