package org.jdr.toilet.common.enums.pit;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 坑位类型枚举
 *
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
    private final String name;

    PitTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static List<Integer> convertCode(List<PitTypeEnum> pitTypes) {
        List<Integer> result = new ArrayList<>(pitTypes.size());
        pitTypes.forEach(pit -> result.add(pit.getCode()));
        return result;
    }

    public static PitTypeEnum getEnumByCode(int code) {
        PitTypeEnum[] enums = values();
        for (PitTypeEnum item : enums) {
            if (item.getCode() == code) {
                return item;
            }
        }
        throw new IllegalArgumentException("code does not exist");
    }

    public static String getNameByCode(int code) {
        return getEnumByCode(code).getName();
    }

}