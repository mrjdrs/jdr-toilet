package org.jdr.toilet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
     * 洗手台类型
     * {@link org.jdr.toilet.common.enums.WishBasinTypeEnum}
     */
    @Column(name = "type")
    private Integer type;

}
