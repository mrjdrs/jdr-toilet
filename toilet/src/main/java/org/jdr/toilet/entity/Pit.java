package org.jdr.toilet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jdr.toilet.common.enums.pit.PitStatusEnum;
import org.jdr.toilet.common.enums.pit.PitTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 坑位实体层
 *
 * @author zhoude
 * @date 2020/9/7 17:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t_toilet_pit")
@Table(name = "t_toilet_pit")
public class Pit extends BaseEntity {

    /**
     * 坑位类型
     * {@link PitTypeEnum}
     */
    @Column(name = "type")
    private Integer type = PitTypeEnum.AUTO_SQUAT.getCode();

    /**
     * 所属厕所id
     */
    @Column(name = "parent_toilet_id")
    private Long parentToiletId = -1L;

    /**
     * 坑位状态
     */
    @Column(name = "status")
    private Integer status = PitStatusEnum.FREEING.getCode();

}
