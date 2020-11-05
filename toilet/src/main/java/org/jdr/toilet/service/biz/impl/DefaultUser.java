package org.jdr.toilet.service.biz.impl;

import org.jdr.toilet.repository.PitRepoService;
import org.jdr.toilet.repository.ToiletRepoService;
import org.jdr.toilet.service.biz.cache.ToiletLocationCache;
import org.springframework.stereotype.Service;

/**
 * @author zhoude
 * @date 2020/9/8 18:17
 */
@Service
public class DefaultUser extends AbstractUser {

    public DefaultUser(ToiletLocationCache toiletLocationCache, ToiletRepoService toiletRepoService, PitRepoService pitRepoService) {
        super(toiletLocationCache, toiletRepoService, pitRepoService);
    }

}