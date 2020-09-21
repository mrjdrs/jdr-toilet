package org.jdr.toilet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
    private String name;

    /**
     * 性别
     * {@link org.jdr.toilet.common.enums.UserSexEnum}
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 用户类型
     * {@link org.jdr.toilet.common.enums.UserTypeEnum}
     */
    @Column(name = "type")
    private Integer type;

}
