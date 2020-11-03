package org.jdr.toilet.common.enums.pit;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum PitTypeEnum {

    /**
     * 蹲式马桶
     */
    AUTO_SQUAT(0, "蹲式"),

    /**
     * 坐式便池
     */
    AUTO_TOILET(1, "马桶"),

    /**
     * 小便池
     */
    AUTO_URINAL(3, "便池"),
    ;

    private final int code;
    private final String desc;

    PitTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static List<Integer> convertCode(List<PitTypeEnum> pitTypes) {
        List<Integer> result = new ArrayList<>(pitTypes.size());
        pitTypes.forEach(pit -> result.add(pit.getCode()));
        return result;
    }

}
