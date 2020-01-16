package com.example.mybatis.service;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.mapper.BossUserMapper;
import com.example.mybatis.model.BossUser;
import com.example.mybatis.model.enums.UserTypeEnum;
import com.example.mybatis.utils.SqlSessionFatoryUtils;
import org.apache.ibatis.session.SqlSession;

public class BossUserService {

    public static void main(String[] args){
        SqlSession sqlSession= SqlSessionFatoryUtils.openSession();
        BossUserMapper mapper=sqlSession.getMapper(BossUserMapper.class);
        BossUser bossUser=mapper.getBossUser("1");
        System.out.println(JSONObject.toJSONString(bossUser));

        bossUser.setId("1111111");
        bossUser.setUsername("mybatis");
        bossUser.setUserType(UserTypeEnum.MANAGER);
        mapper.insertBossUser(bossUser);
        //sqlSession.commit();


    }
}
