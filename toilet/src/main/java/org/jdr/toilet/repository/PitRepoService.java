package org.jdr.toilet.repository;

import lombok.AllArgsConstructor;
import org.jdr.toilet.common.enums.pit.PitStatusEnum;
import org.jdr.toilet.common.enums.pit.PitTypeEnum;
import org.jdr.toilet.entity.Pit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 坑位实体数据访问层-封装
 *
 * @author zhoude
 * @date 2020/9/8 17:05
 */
@Service
@AllArgsConstructor
public class PitRepoService {

    private final PitRepository pitRepository;

    /**
     * 根据所属厕所id、坑位类型、坑位状态获取可用的坑位
     */
    public List<Pit> findByParentToiletIdAndTypeIn(Long parentToiletId, List<PitTypeEnum> type, List<PitStatusEnum> status) {
        return pitRepository.findByParentToiletIdAndTypeInAndStatusIn(parentToiletId, PitTypeEnum.convertCode(type),
                PitStatusEnum.convertCode(status))
                .stream().filter(item -> !item.getIsDelete()).collect(Collectors.toList());
    }

}