package com.example.mybatis.mapper;

import com.example.mybatis.model.BossUser;
import org.apache.ibatis.annotations.Select;

public interface BossUserMapper2 {

    @Select("select id,userName,user_type from bossUser where id=#{id}")
    BossUser getBossUser(String id);
}
