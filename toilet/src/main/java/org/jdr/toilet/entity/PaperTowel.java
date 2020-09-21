package org.jdr.toilet.entity;

import org.jdr.toilet.common.enums.PaperTowelTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 纸巾实体类
 *
 * @author zhoude
 * @date 2020/9/7 18:00
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t_toilet_paper_towel")
@Table(name = "t_toilet_paper_towel")
public class PaperTowel extends BaseEntity {

    /**
     * 纸巾类型
     * {@link PaperTowelTypeEnum}
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 纸巾剩余可用数量；抽纸单位为一包，卷纸单位为一卷
     */
    @Column(name = "remaining_quantity")
    private Integer remainingQuantity;

    /**
     * 单价
     */
    @Column(name = "price")
    private BigDecimal price;

}
