package org.jdr.toilet.common.enums.user;

import lombok.Getter;

/**
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum UserGenderEnum {

    /**
     * 男
     */
    MALE(0, "男"),

    /**
     * 女
     */
    FEMALE(1, "女"),
    ;

    private final int code;
    private final String desc;

    UserGenderEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code获取枚举对象
     */
    public static UserGenderEnum getEnumByCode(int code) {
        UserGenderEnum[] enums = values();
        for (UserGenderEnum item : enums) {
            if (item.getCode() == code) {
                return item;
            }
        }
        throw new IllegalArgumentException("code does not exist");
    }

}