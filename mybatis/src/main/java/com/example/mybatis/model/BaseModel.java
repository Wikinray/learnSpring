package com.example.mybatis.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    /**
     * 主键
     * boss_user.id
     */
    private String id;

    /**
     * 创建人
     * boss_user.CREATED_BY
     */
    private String createdBy;

    /**
     * 创建时间
     * boss_user.CREATED_TIME
     */
    private Date createdTime;

    /**
     * 更新人
     * boss_user.UPDATED_BY
     */
    private String updatedBy;

    /**
     * 更新时间
     * boss_user.UPDATED_TIME
     */
    private Date updatedTime;

    /**
     * boss_user.DELETED
     */
    private Boolean deleted;
}
