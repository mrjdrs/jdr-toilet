package org.jdr.toilet.service.biz.cache;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public static final String LOCATION_KEY = "TOILET_LOCATION";

    /**
     * 初始化所拥有的的厕所位置信息
     */
    public void initLocation() {
        List<Toilet> allToilets = toiletRepoService.findAll();
        allToilets.forEach(toilet -> {
            String[] location = toilet.getLocation().split(":");
            addLocation(new Point(Double.parseDouble(location[0]), Double.parseDouble(location[1])),
                    new ToiletLocationMember(toilet.getId().toString(), toilet.getName()));
        });
        log.info(">>>>>>>>>> 厕所位置信息缓存完毕 <<<<<<<<<<");
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
    public void addLocation(Point point, ToiletLocationMember member) {
        redisTemplate.opsForGeo().add(LOCATION_KEY, point, getLocationMemberName(member));
    }

    /**
     * 计算两个位置的距离
     *
     * @param currMember    当前位置
     * @param compareMember 待比较的位置
     * @return 距离，单位米
     */
    public double distance(ToiletLocationMember currMember, ToiletLocationMember compareMember) {
        Distance distance = redisTemplate.opsForGeo().distance(LOCATION_KEY,
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
    public List<ToiletLocation> getNearbyToilet(Circle circle) {
        List<ToiletLocation> result = new ArrayList<>();

        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                .includeDistance().includeCoordinates();
        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo().radius(LOCATION_KEY,
                circle, args);
        if (radius != null) {
            radius.getContent().forEach(item -> {
                String[] toiletInfo = item.getContent().getName().split(":");
                ToiletLocation toiletLocation = new ToiletLocation(Long.parseLong(toiletInfo[0]), toiletInfo[1],
                        item.getDistance().getValue());
                result.add(toiletLocation);
            });
        }

        return result;
    }

}