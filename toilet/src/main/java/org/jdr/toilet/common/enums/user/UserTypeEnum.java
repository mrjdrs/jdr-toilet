package org.jdr.toilet.common.enums.user;

import lombok.Getter;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum UserTypeEnum {

    /**
     * 普通用户
     */
    NORMAL(0, "普通用户"),

    /**
     * VIP用户
     */
    VIP(1, "VIP用户"),

    /**
     * 管理员
     */
    ADMINISTRATOR(2, "管理员"),
    ;

    private final int code;
    private final String desc;

    UserTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
