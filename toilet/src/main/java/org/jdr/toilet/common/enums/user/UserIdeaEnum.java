package org.jdr.toilet.common.enums.user;

import org.jdr.toilet.common.enums.pit.PitTypeEnum;
import org.jdr.toilet.service.bo.PitBO;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户上厕所的想法枚举
 *
 * @author zhoude
 * @date 2020/9/8 11:39
 */
@Getter
public enum UserIdeaEnum {

    /**
     * 无上厕所想法
     */
    NOTHING(-99, "无上厕所想法"),

    /**
     * 小便
     */
    PEE(0, "小便"),

    /**
     * 大便
     */
    STOOL(1, "大便"),
    ;

    private final int code;
    private final String desc;

    private static final Map<UserIdeaEnum, List<PitTypeEnum>> PITS = new HashMap<>();

//  constructor

    UserIdeaEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

//  method

    static {
        PITS.put(UserIdeaEnum.NOTHING, Collections.emptyList());
        PITS.put(UserIdeaEnum.PEE, PitBO.getPeePit());
        PITS.put(UserIdeaEnum.STOOL, PitBO.getStoolPit());
    }

    /**
     * 由用户想法获取对应的坑位类型
     */
    public List<PitTypeEnum> getPitType() {
        return PITS.get(this);
    }

}
