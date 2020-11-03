package org.jdr.toilet.repository;

import org.jdr.toilet.entity.Category;
import org.jdr.toilet.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 产品实体数据访问层
 *
 * @author zhoude
 * @date 2020/9/8 14:03
 */
@Repository
interface CategoryRepository extends BaseRepository<Category, Long> {
}
