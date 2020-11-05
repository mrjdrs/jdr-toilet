package org.jdr.toilet.repository;

import lombok.AllArgsConstructor;
import org.jdr.toilet.common.enums.toilet.ToiletTypeEnum;
import org.jdr.toilet.entity.Toilet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    /**
     * 根据厕所类型查找可用的厕所
     */
    public List<Toilet> findByType(ToiletTypeEnum toiletType) {
        return repository.findByType(toiletType.getCode()).stream()
                .filter(item -> !item.getIsDelete()).collect(Collectors.toList());
    }

    /**
     * 根据id查找可用的厕所
     */
    public Toilet findById(Long id) {
        Optional<Toilet> result = repository.findById(id);
        if (result.isPresent()) {
            Toilet toilet = result.get();
            if (toilet.getIsDelete()) {
                return toilet;
            }
        }
        return null;
    }

}
