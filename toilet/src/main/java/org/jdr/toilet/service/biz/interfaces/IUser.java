package org.jdr.toilet.service.biz.interfaces;

import org.jdr.toilet.common.enums.pit.PitTypeEnum;
import org.jdr.toilet.entity.Toilet;
import org.jdr.toilet.service.bo.PaperTowelBO;
import org.jdr.toilet.service.bo.PitBO;
import org.jdr.toilet.service.bo.WashBasinBO;

import java.util.List;

/**
 * 上厕所的小伙伴接口
 *
 * @author zhoude
 * @date 2020/9/7 18:05
 */
public interface IUser {

    /**
     * 产生了上厕所的想法（大便、小便）
     * 产生的想法是随机的，有具体想法则往后走，无则结束
     *
     * @return 满足条件的坑位类型
     */
    List<PitTypeEnum> generateIdea();

    /**
     * 找到与想法对应的厕所，大便池可兼容小便池
     *
     * @param pitTypes 需要的坑位类型
     * @return 可用的坑位列表
     */
    List<Toilet> findToilet(List<PitTypeEnum> pitTypes);

    /**
     * 用户行为的决定人是自己，不一定每个都会锁。
     */
    void lockTheDoor(PitBO pit);

    /**
     * 单纯的上厕所
     */
    void restroom(PitBO pit);

    /**
     * 擦屁股
     *
     * @param paperTowel 擦屁股的纸巾
     * @return true=擦屁股成功，false=擦屁股失败
     */
    boolean wipeButt(PaperTowelBO paperTowel);

    /**
     * 冲厕所
     *
     * @return true=冲厕所成功，false=冲厕所失败
     */
    boolean flushTheToilet();

    /**
     * 洗手（行为的决定人是自己，步骤不一定都会执行）
     *
     * @param washBasinBo 具体哪个洗手台
     * @return true=洗了手，false=没洗手
     */
    boolean handwashing(WashBasinBO washBasinBo);

}
