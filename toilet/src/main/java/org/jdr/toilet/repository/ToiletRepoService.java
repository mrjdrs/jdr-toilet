package org.jdr.toilet.repository;

import org.jdr.toilet.entity.Toilet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 厕所实体数据访问层-封装
 *
 * @author zhoude
 * @date 2020/9/8 17:05
 */
@Service
@AllArgsConstructor
public class ToiletRepoService {

    private final ToiletRepository repository;

    /**
     * 查找可用的厕所
     */
    public List<Toilet> findAll() {
        return repository.findAll().stream().filter(item -> !item.getIsDelete()).collect(Collectors.toList());
    }

}
