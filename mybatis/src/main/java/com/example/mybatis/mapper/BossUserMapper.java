package com.example.mybatis.mapper;

import com.example.mybatis.model.BossUser;

import java.util.List;

public interface BossUserMapper {

    BossUser getBossUser(String id);

    int insertBossUser(BossUser user);

    int deleteBossUser(String id);

    int updateBossUser(String id);

    List<BossUser> listBossUser(String userType);
}
