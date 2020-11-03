package org.jdr.toilet.entity;

import org.jdr.toilet.common.enums.toilet.ToiletStatusEnum;
import org.jdr.toilet.common.enums.toilet.ToiletTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 厕所实体类
 *
 * @author zhoude
 * @date 2020/9/7 17:59
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t_toilet_toilet")
@Table(name = "t_toilet_toilet")
public class Toilet extends BaseEntity {

    /**
     * 厕所类型
     * {@link ToiletTypeEnum}
     */
    @Column(name = "type")
    private Integer type = ToiletTypeEnum.MALE_TOILET.getCode();

    /**
     * 厕所楼层
     */
    @Column(name = "floor")
    private Integer floor = -1;

    /**
     * 管理人
     */
    @Column(name = "admin_user_id")
    private Long adminUserId = -1L;

    /**
     * 维修中
     */
    @Column(name = "status")
    private Integer status = ToiletStatusEnum.NORMAL.getCode();

}
