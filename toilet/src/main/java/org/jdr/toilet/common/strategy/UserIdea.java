package org.jdr.toilet.common.strategy;

import org.jdr.toilet.common.enums.UserIdeaEnum;

import java.util.Random;

/**
 * @author zhoude
 * @date 2020/9/8 15:06
 */
public class UserIdea {

    /**
     * 生成用户想法，使用随机数实现
     */
    public UserIdeaEnum generate() {
        Random random = new Random();
        int i = random.nextInt(100);
        if (i == 0) {
            return UserIdeaEnum.NOTHING;
        }
        else if (i % 2 == 0) {
            return UserIdeaEnum.PEE;
        }
        else {
            return UserIdeaEnum.STOOL;
        }
    }

}
