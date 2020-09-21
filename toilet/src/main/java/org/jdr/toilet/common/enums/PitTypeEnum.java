package org.jdr.toilet.common.enums;

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
     * 蹲式马桶有自动冲水功能
     */
    AUTO_SQUAT(0, "自动蹲式"),

    /**
     * 蹲式马桶无自动冲水功能
     */
    MANUAL_SQUAT(1, "手动蹲式"),

    /**
     * 坐式马桶有自动冲水功能
     */
    AUTO_TOILET(2, "自动马桶"),

    /**
     * 坐式马桶无自动冲水功能
     */
    MANUAL_TOILET(3, "手动马桶"),

    /**
     * 小便池有自动冲水功能
     */
    AUTO_URINAL(4, "自动便池"),

    /**
     * 小便池无自动冲水功能
     */
    MANUAL_URINAL(5, "手动便池"),
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
