package org.jdr.toilet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jdr.toilet.common.enums.WishBasinStatusEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 洗手台实体类
 *
 * @author zhoude
 * @date 2020/9/7 18:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t_toilet_wash_basin")
@Table(name = "t_toilet_wash_basin")
public class WashBasin extends BaseEntity {

    /**
     * 所属厕所id
     */
    @Column(name = "parent_toilet_id")
    private Long parentToiletId = -1L;

    /**
     * 洗手台状态
     */
    @Column(name = "status")
    private Integer status = WishBasinStatusEnum.NORMAL.getCode();

}
