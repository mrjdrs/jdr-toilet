package org.jdr.toilet.common.enums;

import lombok.Getter;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum WishBasinTypeEnum {

    /**
     * 自动出水
     */
    AUTO_WATER(0, "自动出水"),

    /**
     * 手动拉闸
     */
    MANUAL_PULL(1, "手动拉闸"),
    ;

    private final int code;
    private final String desc;

    WishBasinTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
