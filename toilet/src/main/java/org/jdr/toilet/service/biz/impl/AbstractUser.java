package org.jdr.toilet.service.biz.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdr.toilet.common.enums.pit.PitStatusEnum;
import org.jdr.toilet.common.enums.pit.PitTypeEnum;
import org.jdr.toilet.entity.Pit;
import org.jdr.toilet.entity.Toilet;
import org.jdr.toilet.entity.User;
import org.jdr.toilet.repository.PitRepoService;
import org.jdr.toilet.repository.ToiletRepoService;
import org.jdr.toilet.service.biz.UserContext;
import org.jdr.toilet.service.biz.cache.ToiletLocationCache;
import org.jdr.toilet.service.biz.interfaces.IUser;
import org.jdr.toilet.service.bo.PitBO;
import org.jdr.toilet.service.bo.ToiletLocation;
import org.jdr.toilet.service.bo.ToiletPitBO;
import org.jdr.toilet.service.bo.user.ShowNearbyToiletsBO;
import org.jdr.toilet.service.bo.user.UserRegisterBO;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
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

    public static final Double SEARCH_DISTANCE = 3.0D;

    @Override
    public void register(UserRegisterBO bo) {
    }

    /**
     * 找到用户想法对应的可用坑位
     *
     * @param needPitType 用户所需坑位类型（如马桶、蹲坑、便池等）
     * @return 可用的坑位列表
     */
    @Override
    public ShowNearbyToiletsBO findToilet(PitTypeEnum needPitType) {
        List<ToiletLocation> nearbyToiletLocation = getNearbyToiletLocation(SEARCH_DISTANCE);
        List<Toilet> nearbyToilet = getNearbyToilet(nearbyToiletLocation);
        List<ToiletPitBO> toiletPitBoList = new ArrayList<>();
        nearbyToiletLocation.forEach(toiletLocation -> {
            ToiletPitBO toiletPitBo = new ToiletPitBO();
            toiletPitBo.setToiletName(toiletLocation.getToiletName());
            toiletPitBo.setToiletDistance(toiletLocation.getDistance());
            toiletPitBo.setNeedPits(userNeedPit(needPitType, nearbyToilet));
            toiletPitBoList.add(toiletPitBo);
        });

        ShowNearbyToiletsBO result = new ShowNearbyToiletsBO();
        result.setToiletPitBo(toiletPitBoList);
        return result;
    }

    /**
     * 获取用户需要的坑位集合
     */
    private List<PitBO> userNeedPit(PitTypeEnum needPitType, List<Toilet> nearbyToilet) {
        List<PitBO> result = new ArrayList<>();
        nearbyToilet.forEach(item -> {
            List<Pit> pits = pitRepoService.findByParentToiletIdAndTypeIn(item.getId(),
                    Collections.singletonList(needPitType), Collections.singletonList(PitStatusEnum.FREEING));
            pits.forEach(pit -> {
                PitBO pitBo = new PitBO();
                pitBo.setPitName(PitTypeEnum.getNameByCode(pit.getStatus()));
                result.add(pitBo);
            });
        });
        return result;
    }

    /**
     * 获取在检索范围内的厕所位置信息
     *
     * @param searchDistance 检索范围，单位米
     * @return 检索范围内的厕所位置信息
     */
    private List<ToiletLocation> getNearbyToiletLocation(Double searchDistance) {
        // 拿到已经报备的的厕所位置信息，得到结果后过滤调返回距离大于有效的检索范围的厕所
        Circle circle = new Circle(currentLocation(), new Distance(searchDistance, RedisGeoCommands.DistanceUnit.MILES));
        return toiletLocationCache.getNearbyToilet(UserContext.getGenderEnum(), circle).stream()
                .filter(item -> item.getDistance() < searchDistance).collect(Collectors.toList());
    }

    /**
     * 获取附近厕所信息
     */
    private List<Toilet> getNearbyToilet(List<ToiletLocation> nearbyToiletLocation) {
        List<Toilet> nearbyToilet = new ArrayList<>(nearbyToiletLocation.size());
        nearbyToiletLocation.forEach(item -> {
            Toilet toilet = toiletRepoService.findById(item.getToiletId());
            if (toilet != null) {
                nearbyToilet.add(toilet);
            }
        });
        return nearbyToilet;
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