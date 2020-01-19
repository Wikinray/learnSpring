package com.example.mybatis.mapper;

import com.example.mybatis.model.BossUser;
import com.example.mybatis.model.PageParams;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface ExampleMapper {

    BossUser getBossUser(String id);

    int insertBossUser(BossUser user);

    int deleteBossUser(String id);

    int updateBossUser(String id);

    List<BossUser> listBossUser(String userType);
}
