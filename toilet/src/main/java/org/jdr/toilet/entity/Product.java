package org.jdr.toilet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 产品表
 *
 * @author zhoude
 * @date 2020/11/3 18:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t_toilet_product")
@Table(name = "t_toilet_product")
public class Product extends BaseEntity {

    /**
     * 产品名称
     */
    @Column(name = "name")
    private String name = StringUtils.EMPTY;

    /**
     * 产品价格（单位元）
     */
    @Column(name = "parent_category_id")
    private BigDecimal parentCategoryId = BigDecimal.ZERO;

    /**
     * 产品库存
     */
    @Column(name = "stock")
    private Integer stock = 0;

    /**
     * 产品类别id
     */
    @Column(name = "product_category_id")
    private Long productCategoryId = -1L;

}