package org.jdr.toilet.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoude
 * @date 2020/9/8 11:41
 */
@Data
@MappedSuperclass
class BaseEntity implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updatedDate;

    /**
     * 逻辑删除；0=未删除，1=已删除
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

}
