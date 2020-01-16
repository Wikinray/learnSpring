package com.example.mybatis.mapper;

import com.example.mybatis.model.EstateInfo;

public interface EstateInfoMapper {

    EstateInfo getEstateInfo(String id);

    int insertEstateInfo(EstateInfo user);
}
