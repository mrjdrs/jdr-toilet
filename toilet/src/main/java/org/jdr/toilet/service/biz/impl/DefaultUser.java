package org.jdr.toilet.service.biz.impl;

import org.jdr.toilet.repository.ToiletRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhoude
 * @date 2020/9/8 18:17
 */
@Service
public class DefaultUser extends AbstractUser {

    @Autowired
    public DefaultUser(ToiletRepoService toiletRepoService) {
        super(toiletRepoService);
    }

}
