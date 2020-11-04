package org.jdr.toilet;

import lombok.extern.slf4j.Slf4j;
import org.jdr.toilet.repository.ToiletRepoService;
import org.jdr.toilet.service.biz.cache.ToiletLocationCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserTests {

    @Autowired
    private ToiletRepoService toiletRepoService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() {
        Point point = new Point(120.516141, 30.418255);
        Distance distance = new Distance(3, RedisGeoCommands.DistanceUnit.KILOMETERS);
        Circle circle = new Circle(point, distance);
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                .includeDistance().includeCoordinates();
        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo().radius(
                ToiletLocationCache.LOCATION_KEY, circle, args);
        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> content = radius.getContent();
        content.forEach(item -> {
            System.out.println(item.getContent().getName() + " > " + item.getDistance().getValue());
        });
    }

}