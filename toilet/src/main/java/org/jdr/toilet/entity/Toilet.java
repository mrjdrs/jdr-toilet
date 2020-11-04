package org.jdr.toilet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.jdr.toilet.common.enums.toilet.ToiletStatusEnum;
import org.jdr.toilet.common.enums.toilet.ToiletTypeEnum;

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
     * 厕所名称
     */
    @Column(name = "name")
    private String name = StringUtils.EMPTY;

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
     * 厕所状态
     * {@link ToiletStatusEnum}
     */
    @Column(name = "status")
    private Integer status = ToiletStatusEnum.NORMAL.getCode();

    /**
     * 厕所位置；用经纬度表示。如30.4185:120.5161表示北纬30°4185′，东经120°5161′
     * 有效的经度是[-180,180]
     * 有效的纬度是[-85.05112878,85.05112878]
     */
    @Column(name = "location")
    private String location = StringUtils.EMPTY;

}
