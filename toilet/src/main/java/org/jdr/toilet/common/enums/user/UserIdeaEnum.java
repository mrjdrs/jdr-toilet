package org.jdr.toilet.common.enums.user;

import lombok.Getter;
import org.jdr.toilet.common.enums.pit.PitTypeEnum;
import org.jdr.toilet.service.domain.PitDomain;

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

    /**
     * 定义用户想法与想法对应的坑位集合
     */
    private static final Map<UserIdeaEnum, List<PitTypeEnum>> PITS = new HashMap<>();

//  constructor

    UserIdeaEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

//  method

    /**
     * 初始化用户想法与想法对应的坑位集合
     */
    static {
        PITS.put(UserIdeaEnum.NOTHING, Collections.emptyList());
        PITS.put(UserIdeaEnum.PEE, PitDomain.getPeePit());
        PITS.put(UserIdeaEnum.STOOL, PitDomain.getStoolPit());
    }

    /**
     * 获取用户想法获取对应的坑位类型
     */
    public List<PitTypeEnum> getPitType() {
        return PITS.get(this);
    }

}
