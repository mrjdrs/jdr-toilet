package org.jdr.toilet.common.enums;

import lombok.Getter;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum ToiletTypeEnum {

    /**
     * 男厕所
     */
    MALE_TOILET(0, "男厕所"),

    /**
     * 女厕所
     */
    FEMALE_TOILET(1, "女厕所"),
    ;

    private final int code;
    private final String desc;

    ToiletTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
