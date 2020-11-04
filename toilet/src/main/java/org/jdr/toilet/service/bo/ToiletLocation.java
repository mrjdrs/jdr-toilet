package org.jdr.toilet.service.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 厕所距离对象
 *
 * @author zhoude
 * @date 2020/9/7 18:12
 */
@Data
@AllArgsConstructor
public class ToiletLocation {

    /**
     * 厕所id
     */
    private Long toiletId;

    /**
     * 厕所名称
     */
    private String toiletName;

    /**
     * 厕所距离位置，单位米
     */
    private Double distance;

}