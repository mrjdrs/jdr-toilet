package org.jdr.toilet.repository;

import org.jdr.toilet.entity.PaperTowel;
import org.jdr.toilet.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 纸巾实体数据访问层
 *
 * @author zhoude
 * @date 2020/9/8 14:03
 */
@Repository
interface PaperTowelRepository extends BaseRepository<PaperTowel, Long> {
}
