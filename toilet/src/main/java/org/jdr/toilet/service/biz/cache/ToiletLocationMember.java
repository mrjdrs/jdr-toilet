package org.jdr.toilet.service.biz.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 厕所成员位置对象
 *
 * @author zhoude
 * @date 2020/11/4 15:06
 */
@AllArgsConstructor
@Getter
public class ToiletLocationMember {

    /**
     * 成员名称头
     */
    private String head;

    /**
     * 成员名称
     */
    private String name;

}