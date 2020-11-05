package org.jdr.toilet.service.biz.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdr.toilet.common.enums.pit.PitStatusEnum;
import org.jdr.toilet.common.enums.pit.PitTypeEnum;
import org.jdr.toilet.common.enums.user.UserIdeaEnum;
import org.jdr.toilet.entity.Pit;
import org.jdr.toilet.entity.Toilet;
import org.jdr.toilet.entity.User;
import org.jdr.toilet.repository.PitRepoService;
import org.jdr.toilet.repository.ToiletRepoService;
import org.jdr.toilet.service.biz.cache.ToiletLocationCache;
import org.jdr.toilet.service.biz.interfaces.IUser;
import org.jdr.toilet.service.bo.PitBO;
import org.jdr.toilet.service.bo.ToiletBO;
import org.jdr.toilet.service.bo.ToiletLocation;
import org.jdr.toilet.service.bo.user.ShowNearbyToiletsBO;
import org.jdr.toilet.service.bo.user.UserRegisterBO;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 默认的用户行为实现
 *
 * @author zhoude
 * @date 2020/9/7 18:23
 */
@Service
@AllArgsConstructor
@Slf4j
public abstract class AbstractUser implements IUser {

    private final ToiletLocationCache toiletLocationCache;
    private final ToiletRepoService toiletRepoService;
    private final PitRepoService pitRepoService;

    @Override
    public void register(UserRegisterBO bo) {
    }

    /**
     * 找到用户想法对应的可用坑位
     *
     * @param userIdea 用户需要上厕所的类型（如大便、小便等）
     * @param pitType  用户所需坑位类型（如马桶、蹲坑等），若传入类型为null则标识未选择，不过滤结果
     *                 如用户选择大便，会得出蹲坑和马桶，但用户又不想用马桶，所以pitType就需要指定马桶
     * @param token    访问令牌
     * @return 可用的坑位列表
     */
    @Override
    public ShowNearbyToiletsBO findToilet(UserIdeaEnum userIdea, PitTypeEnum pitType, String token) {
        // 1.拿到附近3公里的厕所信息
        // 2.根据用户性别，过滤掉不满足的厕所类型
        // 3.查剩下这些厕所的可用坑位
        // 4.过滤调用户不想要的坑位类型
        // 5.返回剩下的坑位
        User user = currentUser(token);
        List<ToiletLocation> nearbyToiletLocation = getNearbyToiletLocation();
        List<Toilet> nearbyToilet = getNearbyToilet(nearbyToiletLocation, user);
        List<Pit> pits = userNeedPit(userIdea, pitType, nearbyToilet);

        // todo
        List<ToiletBO> toiletBoList = new ArrayList<>();
        ToiletBO toiletBo = new ToiletBO();
        toiletBo.setToiletName("");
        toiletBo.setToiletDistance(0.0D);
        toiletBo.setNeedPits(new ArrayList<Pit>());
        toiletBoList.add(toiletBo);

        ShowNearbyToiletsBO result = new ShowNearbyToiletsBO();
        result.setToiletBo(toiletBoList);
        return result;
    }

    private List<Pit> userNeedPit(UserIdeaEnum userIdea, PitTypeEnum pitType, List<Toilet> nearbyToilet) {
        List<PitTypeEnum> correspondPitType = userIdea.getPitType().stream().filter(pitType::equals)
                .collect(Collectors.toList());
        List<Pit> result = new ArrayList<>();
        nearbyToilet.forEach(item -> {
            result.addAll(pitRepoService.findByParentToiletIdAndTypeIn(item.getId(), correspondPitType,
                    Collections.singletonList(PitStatusEnum.FREEING)));
        });
        return result;
    }

    private List<ToiletLocation> getNearbyToiletLocation() {
        // 获取有效的检索范围
        double configDistance = 3000;
        // 拿到已经报备的的厕所位置信息，得到结果后过滤调返回距离大于有效的检索范围的厕所
        Circle circle = new Circle(currentLocation(), new Distance(configDistance, Metrics.KILOMETERS));
        return toiletLocationCache.getNearbyToilet(circle).stream()
                .filter(item -> item.getDistance() < configDistance).collect(Collectors.toList());
    }

    private List<Toilet> getNearbyToilet(List<ToiletLocation> nearbyToiletLocation, User user) {
        List<Toilet> nearbyToilet = new ArrayList<>(nearbyToiletLocation.size());
        nearbyToiletLocation.forEach(item -> {
            Toilet toilet = toiletRepoService.findById(item.getToiletId());
            if (toilet != null) {
                nearbyToilet.add(toilet);
            }
        });
        return nearbyToilet.stream().filter(item -> user.getSex().equals(item.getType()))
                .collect(Collectors.toList());
    }

    /**
     * 获取当前定位
     *
     * @return 当前位置的经纬度
     */
    @Override
    public Point currentLocation() {
        // 由子类实现
        throw new UnsupportedOperationException("unsupportedOperation");
    }

    /**
     * 获取当前用户
     *
     * @return 当前位置的经纬度
     */
    public User currentUser(String token) {
        // 由子类实现
        throw new UnsupportedOperationException("unsupportedOperation");
    }

    @Override
    public void restroom(PitBO pit) {

    }

}