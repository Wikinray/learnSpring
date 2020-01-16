package com.example.mybatis.service;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.mapper.EstateInfoMapper;
import com.example.mybatis.model.EstateInfo;
import com.example.mybatis.model.enums.CityEnum;
import com.example.mybatis.utils.SqlSessionFatoryUtils;
import org.apache.ibatis.session.SqlSession;

public class CityService {

    public static void main(String[] args){
        SqlSession sqlSession= SqlSessionFatoryUtils.openSession();
        EstateInfoMapper mapper=sqlSession.getMapper(EstateInfoMapper.class);
        EstateInfo bossUser=mapper.getEstateInfo("20191105C06641328288194625536");

        bossUser.setId("1111111");
        bossUser.setCity(CityEnum.TaiYuan);
        bossUser.setEstateName("金地测试中心");
        mapper.insertEstateInfo(bossUser);
        sqlSession.commit();

        System.out.println(JSONObject.toJSONString(bossUser));
    }
}
