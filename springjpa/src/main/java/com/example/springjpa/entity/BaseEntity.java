package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {

    /**
     * 主键
     * boss_user.id
     */
    @Id
    @Column
    private String id;

    /**
     * 创建人
     * boss_user.CREATED_BY
     */
    @Column
    private String createdBy;

    /**
     * 创建时间
     * boss_user.CREATED_TIME
     */
    @Column
    private Date createdTime;

    /**
     * 更新人
     * boss_user.UPDATED_BY
     */
    @Column
    private String updatedBy;

    /**
     * 更新时间
     * boss_user.UPDATED_TIME
     */
    @Column
    private Date updatedTime;

    /**
     * boss_user.DELETED
     */
    @Column
    private Boolean deleted;
}
