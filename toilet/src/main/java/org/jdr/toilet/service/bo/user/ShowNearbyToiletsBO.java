package org.jdr.toilet.service.bo.user;

import lombok.Data;
import org.jdr.toilet.service.bo.ToiletPitBO;

import java.util.List;

/**
 * @author zhoude
 * @date 2020/11/4 10:25
 */
@Data
public class ShowNearbyToiletsBO {

    private List<ToiletPitBO> toiletPitBo;

}