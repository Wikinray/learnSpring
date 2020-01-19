package com.example.mybatis.model;

import com.example.mybatis.model.enums.CityEnum;
import com.example.mybatis.model.enums.UserTypeEnum;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;



@Data
//重命名避免重名问题
@Alias(value = "bossUser")
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
    private UserTypeEnum userType;

    /**
     * 乐观锁
     * boss_user.REVISION
     */
    private Integer revision;
}
