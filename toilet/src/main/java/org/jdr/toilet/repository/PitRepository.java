package org.jdr.toilet.repository;

import org.jdr.toilet.entity.Pit;
import org.jdr.toilet.repository.base.BaseRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 坑位实体数据访问层
 *
 * @author zhoude
 * @date 2020/9/8 14:03
 */
@Repository
interface PitRepository extends BaseRepository<Pit, Long> {

    /**
     * 根据所属厕所id、坑位类型获取
     *
     * @param parentToiletId 所属厕所id
     * @param type           坑位类型获取
     * @param status         坑位状态
     * @return 满足条件的坑位
     */
    List<Pit> findByParentToiletIdAndTypeInAndStatusIn(@Param("parentToiletId") Long parentToiletId,
                                                       @Param("type") List<Integer> type,
                                                       @Param("status") List<Integer> status);

}