package org.jdr.toilet.common.enums;

import lombok.Getter;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum PaperTowelTypeEnum {

    /**
     * 抽纸
     */
    DRAW_PAPER(0, "抽纸"),

    /**
     * 卷纸
     */
    ROLL_PAPER(1, "卷纸"),
    ;

    private final int code;
    private final String desc;

    PaperTowelTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
