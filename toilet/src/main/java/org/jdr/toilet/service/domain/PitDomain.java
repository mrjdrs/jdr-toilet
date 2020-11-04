package org.jdr.toilet.service.domain;

import org.jdr.toilet.common.enums.pit.PitTypeEnum;

import java.util.Arrays;
import java.util.List;

/**
 * 上厕所的小伙伴domain
 *
 * @author zhoude
 * @date 2020/9/7 18:03
 */
public class PitDomain {

    /**
     * 获取小便坑位
     */
    public static List<PitTypeEnum> getPeePit() {
        return Arrays.asList(PitTypeEnum.values());
    }

    /**
     * 获取大便坑位
     */
    public static List<PitTypeEnum> getStoolPit() {
        return Arrays.asList(PitTypeEnum.AUTO_SQUAT, PitTypeEnum.AUTO_TOILET);
    }

}