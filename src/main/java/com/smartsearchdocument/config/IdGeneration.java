package com.smartsearchdocument.config;

import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.util.IdUtil;
import com.smartsearchdocument.util.StrUtil;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.stereotype.Component;

/**
 * id生成器
 *
 * @author NotEdibleSalt
 */
@Component
public class IdGeneration<T extends DOBase> implements BeforeConvertCallback<T> {

    @Override
    public T onBeforeConvert(T aggregate) {

        if (StrUtil.isBlank(aggregate.getId())) {
            aggregate.setId(IdUtil.getIdStr());
            aggregate.setNotDel(true);
        }

        return aggregate;
    }
}
