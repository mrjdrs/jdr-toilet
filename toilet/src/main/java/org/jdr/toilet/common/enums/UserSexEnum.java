package org.jdr.toilet.common.enums;

import lombok.Getter;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum UserSexEnum {

    /**
     * 男人
     */
    MALE(0, "男人"),

    /**
     * 女人
     */
    FEMALE(1, "女人"),
    ;

    private final int code;
    private final String desc;

    UserSexEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
