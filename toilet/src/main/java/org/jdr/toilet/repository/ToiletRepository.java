package org.jdr.toilet.repository;

import org.jdr.toilet.entity.Toilet;
import org.jdr.toilet.repository.base.BaseRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 厕所实体数据访问层
 *
 * @author zhoude
 * @date 2020/9/8 14:03
 */
@Repository
interface ToiletRepository extends BaseRepository<Toilet, Long> {

    /**
     * 根据厕所类型查
     *
     * @param type 厕所类型
     * @return 厕所实体类
     */
    List<Toilet> findByType(@Param("type") Integer type);

}