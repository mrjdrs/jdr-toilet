package org.jdr.toilet.service.biz.interfaces;

import org.jdr.toilet.common.enums.pit.PitTypeEnum;
import org.jdr.toilet.common.enums.user.UserIdeaEnum;
import org.jdr.toilet.service.bo.PitBO;
import org.jdr.toilet.service.bo.user.ShowNearbyToiletsBO;
import org.jdr.toilet.service.bo.user.UserRegisterBO;
import org.springframework.data.geo.Point;

/**
 * 上厕所的小伙伴接口
 *
 * @author zhoude
 * @date 2020/9/7 18:05
 */
public interface IUser {

    /**
     * 注册
     *
     * @param bo 用户注册业务对象
     */
    void register(UserRegisterBO bo);

    /**
     * 找到用户想法对应的可用坑位
     *
     * @param userIdea 用户需要上厕所的类型（如大便、小便等）
     * @param pitType  用户所需坑位类型（如马桶、蹲坑等），若传入类型为null则标识未选择，不过滤结果
     *                 如用户选择大便，会得出蹲坑和马桶，但用户又不想用马桶，所以pitType就需要指定马桶
     * @return 可用的坑位列表
     */
    ShowNearbyToiletsBO findToilet(UserIdeaEnum userIdea, PitTypeEnum pitType, String token);

    /**
     * 得到当前定位
     */
    Point currentLocation();

    /**
     * 单纯的上厕所
     *
     * @param pit 坑位业务层
     */
    void restroom(PitBO pit);

}