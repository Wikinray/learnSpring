package example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class BossUser extends BaseEntity{

    /**
     * 用户名
     * boss_user.userName
     */
    @Column
    private String username;

    /**
     * 密码
     * boss_user.password
     */
    @Column
    private String password;

    /**
     * boss_user.estate_id
     */
    @Column
    private String estateId;

    /**
     * boss_user.activity_code
     */
    @Column
    private String activityCode;

    /**
     * boss_user.user_type
     */
    @Column
    private String userType;

    /**
     * 乐观锁
     * boss_user.REVISION
     */
    @Column
    private Integer revision;
}
