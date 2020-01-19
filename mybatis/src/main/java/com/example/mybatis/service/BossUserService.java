package com.example.mybatis.service;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.mapper.BossUserMapper;
import com.example.mybatis.model.BossUser;
import com.example.mybatis.model.PageParams;
import com.example.mybatis.model.enums.UserTypeEnum;
import com.example.mybatis.utils.SqlSessionFatoryUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossUserService {
    static SqlSession sqlSession;
    static BossUserMapper mapper;

    public BossUserService(){
        sqlSession= SqlSessionFatoryUtils.openSession();
        mapper=sqlSession.getMapper(BossUserMapper.class);
    }

    public static void main(String[] args){
        BossUserService service=new BossUserService();
        //service.selectOne(mapper);

        service.insert2();
    }

    public void selectOne(){
        BossUser bossUser=mapper.getBossUser("1");
        System.out.println(JSONObject.toJSONString(bossUser));
    }

    /**
     * map 参数方式不推荐
     * 1、key必须确定正确
     * 2、值不能限定数据类型
     */
    public void selectOne2(){
        Map<String ,Object> parameterMap=new HashMap<>();
        parameterMap.put("id","1");
        parameterMap.put("userType","boss");
        BossUser bossUser=mapper.getBossUser2(parameterMap);
        System.out.println(JSONObject.toJSONString(bossUser));
    }

    /**
     * @Param 注解方式
     */
    public void selectOne3(){
        BossUser bossUser=mapper.getBossUser3("1","boss");
        System.out.println(JSONObject.toJSONString(bossUser));
    }

    /**
     * javaBean方式
     */
    public void selectOne4(){
        BossUser user=new BossUser();
        user.setId("1");
        user.setUserType(UserTypeEnum.BOSS);
        BossUser bossUser=mapper.getBossUser4(user);
        System.out.println(JSONObject.toJSONString(bossUser));
    }

    /**
     * @Param 混合使用
     */
    public void selectOne5(){
        BossUser user=new BossUser();
        user.setUserType(UserTypeEnum.OFFLINE);
        PageParams pageParams=PageParams.builder().start(2).limit(1).build();
        BossUser bossUser=mapper.getBossUser5(user,pageParams);
        System.out.println(JSONObject.toJSONString(bossUser));
    }

    public void count(){
        int num=mapper.countBossUser("manager");
        System.out.println(JSONObject.toJSONString(num));
    }

    public void insert(BossUserMapper mapper){
        BossUser bossUser=new BossUser();
        bossUser.setId("1111111");
        bossUser.setUsername("mybatis");
        bossUser.setUserType(UserTypeEnum.MANAGER);
        mapper.insertBossUser(bossUser);
        sqlSession.commit();
    }

    public void insert2(){
        //不能执行成功
        BossUser bossUser=new BossUser();
        bossUser.setUsername("mybatis");
        bossUser.setUserType(UserTypeEnum.MANAGER);
        mapper.insertBossUser2(bossUser);
        sqlSession.commit();
        System.out.println(bossUser);
    }

    public void list2(){
        RowBounds rowBounds=new RowBounds(0,20);
        List<BossUser> bossUser=mapper.listBossUser2("offline",rowBounds);
        System.out.println(JSONObject.toJSONString(bossUser));
    }
}
