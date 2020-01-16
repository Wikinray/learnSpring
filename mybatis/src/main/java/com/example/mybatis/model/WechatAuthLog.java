package com.example.mybatis.model;

import com.example.mybatis.model.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WechatAuthLog extends BaseModel{

    /**
     * 用户id
     */
    private String userCode;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private SexEnum sex;
}
