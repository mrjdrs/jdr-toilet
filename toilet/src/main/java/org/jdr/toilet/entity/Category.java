package org.jdr.toilet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 产品类别表
 *
 * @author zhoude
 * @date 2020/11/3 18:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t_toilet_category")
@Table(name = "t_toilet_category")
public class Category extends BaseEntity {

    /**
     * 产品类别名称
     */
    @Column(name = "name")
    private String name = StringUtils.EMPTY;

    /**
     * 父类产品id
     */
    @Column(name = "price")
    private Long price = -1L;

}