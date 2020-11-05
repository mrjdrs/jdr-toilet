package org.jdr.toilet.service.biz.cache;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdr.toilet.common.enums.toilet.ToiletTypeEnum;
import org.jdr.toilet.common.enums.user.UserGenderEnum;
import org.jdr.toilet.entity.Toilet;
import org.jdr.toilet.repository.ToiletRepoService;
import org.jdr.toilet.service.bo.ToiletLocation;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 厕所位置缓存
 *
 * @author zhoude
 * @date 2020/11/4 13:59
 */
@Service
@Slf4j
@AllArgsConstructor
public class ToiletLocationCache {

    private final ToiletRepoService toiletRepoService;
    private final RedisTemplate<String, String> redisTemplate;

    private static final String MALE_TOILET_LOCATION_KEY = "MALE_TOILET_LOCATION";
    private static final String FEMALE_TOILET_LOCATION_KEY = "FEMALE_TOILET_LOCATION";

    /**
     * 初始化所拥有的的厕所位置信息
     */
    public void initLocation() {
        List<Toilet> maleToilets = toiletRepoService.findByType(ToiletTypeEnum.MALE_TOILET);
        maleToilets.forEach(toilet -> addLocation(MALE_TOILET_LOCATION_KEY, toilet));
        log.info(">>>>>>>>>> 男厕所位置信息缓存完毕 <<<<<<<<<<");

        List<Toilet> femaleToilets = toiletRepoService.findByType(ToiletTypeEnum.FEMALE_TOILET);
        femaleToilets.forEach(toilet -> addLocation(FEMALE_TOILET_LOCATION_KEY, toilet));
        log.info(">>>>>>>>>> 女厕所位置信息缓存完毕 <<<<<<<<<<");
    }

    /**
     * 添加一个位置
     *
     * @param toilet 厕所实体类
     */
    private void addLocation(String key, Toilet toilet) {
        String[] location = toilet.getLocation().split(":");
        addLocation(key, new Point(Double.parseDouble(location[0]), Double.parseDouble(location[1])),
                new ToiletLocationMember(toilet.getId().toString(), toilet.getName()));
    }

    /**
     * 获取成员位置名称
     *
     * @param member 厕所成员位置对象
     * @return 成员位置名称
     */
    public static String getLocationMemberName(ToiletLocationMember member) {
        return MessageFormat.format("{0}:{1}", member.getHead(), member.getName());
    }

    /**
     * 添加一个位置
     *
     * @param point  位置对象
     * @param member 厕所成员位置对象
     */
    public void addLocation(String key, Point point, ToiletLocationMember member) {
        String locationMemberName = getLocationMemberName(member);
        redisTemplate.opsForGeo().add(key, point, locationMemberName);
        log.info("厕所{}添加完毕", locationMemberName);
    }

    /**
     * 计算两个位置的距离
     *
     * @param gender        性别
     * @param currMember    当前位置
     * @param compareMember 待比较的位置
     * @return 距离，单位米
     */
    public double distance(UserGenderEnum gender, ToiletLocationMember currMember, ToiletLocationMember compareMember) {
        Distance distance = redisTemplate.opsForGeo().distance(getToiletKey(gender),
                getLocationMemberName(currMember), getLocationMemberName(compareMember),
                RedisGeoCommands.DistanceUnit.METERS);
        if (distance == null) {
            return 0;
        }
        return distance.getValue();
    }

    /**
     * 获取附近的厕所
     */
    public List<ToiletLocation> getNearbyToilet(UserGenderEnum gender, Circle circle) {
        List<ToiletLocation> result = new ArrayList<>();

        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                .includeDistance().includeCoordinates();
        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo().radius(getToiletKey(gender),
                circle, args);
        if (radius != null) {
            radius.getContent().forEach(item -> {
                String[] toiletInfo = item.getContent().getName().split(":");
                ToiletLocation toiletLocation = new ToiletLocation(Long.parseLong(toiletInfo[0]), toiletInfo[1],
                        // todo 距离可能为不为实数，如=1.0E-4
                        item.getDistance().getValue());
                result.add(toiletLocation);
            });
        }

        return result;
    }

    private String getToiletKey(UserGenderEnum gender) {
        if (UserGenderEnum.MALE.getCode() == gender.getCode()) {
            return MALE_TOILET_LOCATION_KEY;
        }
        return FEMALE_TOILET_LOCATION_KEY;
    }

}