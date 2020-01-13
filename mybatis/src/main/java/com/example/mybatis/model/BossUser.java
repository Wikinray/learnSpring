package com.example.mybatis.model;

import lombok.Data;

@Data
public class BossUser extends BaseModel{

    /**
     * 用户名
     * boss_user.userName
     */
    private String username;

    /**
     * 密码
     * boss_user.password
     */
    private String password;

    /**
     * boss_user.estate_id
     */
    private String estateId;

    /**
     * boss_user.activity_code
     */
    private String activityCode;

    /**
     * boss_user.user_type
     */
    private String userType;

    /**
     * 乐观锁
     * boss_user.REVISION
     */
    private Integer revision;
}
