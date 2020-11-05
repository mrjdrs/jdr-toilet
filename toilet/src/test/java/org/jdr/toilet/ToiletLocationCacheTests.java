package org.jdr.toilet;

import lombok.extern.slf4j.Slf4j;
import org.jdr.toilet.common.enums.user.UserGenderEnum;
import org.jdr.toilet.service.biz.cache.ToiletLocationCache;
import org.jdr.toilet.service.bo.ToiletLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 厕所位置缓存逻辑测试
 *
 * @author zhoude
 * @date 2020/11/5 15:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ToiletLocationCacheTests {

    @Autowired
    private ToiletLocationCache toiletLocationCache;

    @Test
    public void testInitLocation() {
        toiletLocationCache.initLocation();
    }

    @Test
    public void testDistance() {
        // todo 有空指针问题
        /*ToiletLocationMember currMember = new ToiletLocationMember("1", "厕所1号");
        ToiletLocationMember compareMember = new ToiletLocationMember("3", "厕所3号");
        double distance = toiletLocationCache.distance(UserGenderEnum.MALE, currMember, compareMember);
        log.info(String.valueOf(distance));*/
    }

    @Test
    public void testGetNearbyToilet() {
        Circle circle = new Circle(new Point(120.51, 30.41), new Distance(3, RedisGeoCommands.DistanceUnit.MILES));
        List<ToiletLocation> nearbyToilet = toiletLocationCache.getNearbyToilet(UserGenderEnum.MALE, circle);
        System.out.println(nearbyToilet);
    }

}