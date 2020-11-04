package org.jdr.toilet.service.bo;

import lombok.Data;
import org.jdr.toilet.entity.Pit;

import java.util.List;

/**
 * 厕所业务对象
 *
 * @author zhoude
 * @date 2020/9/7 18:12
 */
@Data
public class ToiletBO {

    /**
     * 厕所名称
     */
    private String toiletName;

    /**
     * 厕所距离位置
     */
    private Double toiletDistance;

    /**
     * 此厕所中用户需要的坑位
     */
    private List<Pit> needPits;

}