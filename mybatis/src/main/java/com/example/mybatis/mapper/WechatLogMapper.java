package com.example.mybatis.mapper;

import com.example.mybatis.model.WechatAuthLog;

public interface WechatLogMapper {

    WechatAuthLog getWechatLog(String id);

    int insertWechatLog(WechatAuthLog user);
}
