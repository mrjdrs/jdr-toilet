package org.jdr.toilet.repository;

import org.jdr.toilet.entity.WashBasin;
import org.jdr.toilet.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 洗手台实体数据访问层
 *
 * @author zhoude
 * @date 2020/9/8 14:03
 */
@Repository
interface WashBasinRepository extends BaseRepository<WashBasin, Long> {
}
