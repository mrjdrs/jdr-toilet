package org.jdr.toilet.service.bo;

import org.jdr.toilet.common.enums.PitTypeEnum;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 坑位业务层
 *
 * @author zhoude
 * @date 2020/9/7 18:13
 */
@Data
public class PitBO {

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
        return Arrays.asList(PitTypeEnum.AUTO_SQUAT, PitTypeEnum.MANUAL_SQUAT, PitTypeEnum.AUTO_TOILET,
                PitTypeEnum.MANUAL_TOILET);
    }

}
