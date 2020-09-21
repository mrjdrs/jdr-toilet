package org.jdr.toilet;

import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.utils.$;
import org.jdr.toilet.common.enums.PitTypeEnum;
import org.jdr.toilet.entity.Toilet;
import org.jdr.toilet.service.biz.interfaces.IUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserTests {

    @Autowired
    private IUser user;

    @Test
    public void testGenerateIdea() {
        List<PitTypeEnum> pitTypes = user.generateIdea();
        pitTypes.forEach(item -> System.out.println(item.getDesc()));
    }

    @Test
    public void findToilet() {
//        List<PitTypeEnum> pitTypeEnums = user.generateIdea();
//        List<Toilet> toilet = user.findToilet(pitTypeEnums);
//        log.info($.toJson(toilet));

        List<PitTypeEnum> pitTypeEnums = Collections.singletonList(PitTypeEnum.AUTO_SQUAT);
        List<Toilet> toilet = user.findToilet(pitTypeEnums);
        log.info($.toJson(toilet));
    }

}
