package org.jdr.toilet.entity;

import org.jdr.toilet.common.enums.ToiletTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Integer type;

    /**
     * 厕所楼层
     */
    @Column(name = "floor")
    private Integer floor;

    /**
     * 管理人
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "admin", referencedColumnName = "id")
    private User admin;

}
