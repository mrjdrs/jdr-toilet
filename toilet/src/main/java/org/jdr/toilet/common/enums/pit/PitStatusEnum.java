package org.jdr.toilet.common.enums.pit;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum PitStatusEnum {

    /**
     * 清洁完毕后等同于空闲状态
     */
    FREEING(0, "0=空闲状态[清洁完毕]"),

    /**
     * 使用中
     */
    USE(1, "使用中"),

    /**
     * 待清洁
     */
    WAIT_CLEANED(2, "待清洁"),

    /**
     * 维修中
     */
    REPAIRING(3, "维修中"),
    ;

    private final int code;
    private final String desc;

    PitStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static List<Integer> convertCode(List<PitStatusEnum> pitTypes) {
        List<Integer> result = new ArrayList<>(pitTypes.size());
        pitTypes.forEach(pit -> result.add(pit.getCode()));
        return result;
    }

}