package org.jdr.toilet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.jdr.toilet.common.enums.user.UserSexEnum;
import org.jdr.toilet.common.enums.user.UserStatusEnum;
import org.jdr.toilet.common.enums.user.UserTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户实体类
 *
 * @author zhoude
 * @date 2020/9/7 17:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t_toilet_user")
@Table(name = "t_toilet_user")
public class User extends BaseEntity {

    /**
     * 用户姓名
     */
    @Column(name = "name")
    private String name = StringUtils.EMPTY;

    /**
     * 性别
     * {@link org.jdr.toilet.common.enums.user.UserSexEnum}
     */
    @Column(name = "sex")
    private Integer sex = UserSexEnum.MALE.getCode();

    /**
     * 用户手机号
     */
    @Column(name = "mobile")
    private String mobile = StringUtils.EMPTY;

    /**
     * 用户类型
     * {@link org.jdr.toilet.common.enums.user.UserTypeEnum}
     */
    @Column(name = "type")
    private Integer type = UserTypeEnum.NORMAL.getCode();

    /**
     * 用户状态
     * {@link org.jdr.toilet.common.enums.user.UserStatusEnum}
     */
    @Column(name = "status")
    private Integer status = UserStatusEnum.NORMAL.getCode();

}
