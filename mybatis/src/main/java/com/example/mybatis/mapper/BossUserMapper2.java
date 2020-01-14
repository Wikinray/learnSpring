package com.example.mybatis.mapper;

import com.example.mybatis.model.BossUser;
import org.apache.ibatis.annotations.Select;

public interface BossUserMapper2 {

    @Select("select id,userName,user_type from boss_User where id=#{id}")
    BossUser getBossUser2(String id);
}
