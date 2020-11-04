package org.jdr.toilet.common.runner;

import lombok.AllArgsConstructor;
import org.jdr.toilet.service.biz.cache.ToiletLocationCache;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化缓存
 *
 * @author zhoude
 * @date 2020/11/4 13:58
 */
@Component
@AllArgsConstructor
public class CacheInitRunner implements CommandLineRunner {

    private final ToiletLocationCache toiletLocationCache;

    @Override
    public void run(String... args) throws Exception {
        toiletLocationCache.initLocation();
    }

}