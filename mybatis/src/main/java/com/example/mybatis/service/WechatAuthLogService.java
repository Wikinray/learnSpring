package com.example.mybatis.service;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.mapper.EstateInfoMapper;
import com.example.mybatis.mapper.WechatLogMapper;
import com.example.mybatis.model.EstateInfo;
import com.example.mybatis.model.WechatAuthLog;
import com.example.mybatis.model.enums.CityEnum;
import com.example.mybatis.model.enums.SexEnum;
import com.example.mybatis.utils.SqlSessionFatoryUtils;
import org.apache.ibatis.session.SqlSession;

public class WechatAuthLogService {

    public static void main(String[] args){
        SqlSession sqlSession= SqlSessionFatoryUtils.openSession();
        WechatLogMapper mapper=sqlSession.getMapper(WechatLogMapper.class);
        WechatAuthLog authLog=mapper.getWechatLog("20190807C06608714187966775296");
        System.out.println(JSONObject.toJSONString(authLog));

        authLog.setId("1111111");
        authLog.setNickName("test");
        authLog.setSex(SexEnum.UNKNOWN);
        mapper.insertWechatLog(authLog);
        sqlSession.commit();
    }
}
