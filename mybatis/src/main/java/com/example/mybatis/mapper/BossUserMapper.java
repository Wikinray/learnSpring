package com.example.mybatis.mapper;

import com.example.mybatis.model.BossUser;
import com.example.mybatis.model.PageParams;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface BossUserMapper {

    BossUser getBossUser(String id);

    BossUser getBossUser2(Map<String ,Object> parameterMap);

    BossUser getBossUser3(@Param("id")String id,@Param("userType")String userType);

    BossUser getBossUser4(BossUser user);

    BossUser getBossUser5(@Param("bossUser") BossUser user, @Param("page")PageParams pageParams);

    int insertBossUser(BossUser user);

    int insertBossUser2(BossUser user);

    int deleteBossUser(String id);

    int updateBossUser(String id);

    List<BossUser> listBossUser(String userType);

    List<BossUser> listBossUser2(@Param("userType") String userType, RowBounds rowBounds);

    int countBossUser(String userType);
}
