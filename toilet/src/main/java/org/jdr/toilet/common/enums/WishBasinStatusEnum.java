package org.jdr.toilet.common.enums;

import lombok.Getter;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum WishBasinStatusEnum {

    /**
     * 正常运行
     */
    NORMAL(0, "正常运行"),

    /**
     * 维修中
     */
    REPAIR(1, "维修中"),
    ;

    private final int code;
    private final String desc;

    WishBasinStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
