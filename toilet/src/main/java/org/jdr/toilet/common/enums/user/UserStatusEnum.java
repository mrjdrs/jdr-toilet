package org.jdr.toilet.common.enums.user;

import lombok.Getter;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum UserStatusEnum {

    /**
     * 正常用户
     */
    NORMAL(0, "正常用户"),

    /**
     * 用户已注销
     */
    LOGOUT(1, "用户已注销"),
    ;

    private final int code;
    private final String desc;

    UserStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
