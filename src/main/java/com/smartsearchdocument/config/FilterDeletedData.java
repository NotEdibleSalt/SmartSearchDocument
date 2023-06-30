package com.smartsearchdocument.config;

import com.smartsearchdocument.common.DOBase;
import org.springframework.data.relational.core.mapping.event.AfterConvertCallback;
import org.springframework.stereotype.Component;

/**
 * 过滤已删除的数据
 *
 * @author NotEdibleSalt
 */
@Component
public class FilterDeletedData<T extends DOBase> implements AfterConvertCallback<T> {


    @Override
    public T onAfterConvert(T aggregate) {

        return aggregate;
    }

}
