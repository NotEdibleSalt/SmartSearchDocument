package com.smartsearchdocument.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;

/**
 * 集合工具类
 */
public class CollUtil {

    private CollUtil() {}

    public static boolean isEmpty(Map<?, ?> map) {

        return null == map || map.isEmpty();
    }

    public static boolean isEmpty(Iterable<?> iterable) {

        return null == iterable || isEmpty(iterable.iterator());
    }

    public static boolean isEmpty(Iterator<?> iterator) {

        return null == iterator || !iterator.hasNext();
    }

    public static boolean isEmpty(Object[] array) {

        if (array != null) {
            return 0 == Array.getLength(array);
        }

        return true;
    }


    public static boolean isNotEmpty(Map<?, ?> map) {

        return !isEmpty(map);
    }

    public static boolean isNotEmpty(Iterable<?> iterator) {

        return !isEmpty(iterator);
    }

    public static boolean isNotEmpty(Iterator<?> iterator) {

        return !isEmpty(iterator);
    }

    public static boolean isNotEmpty(Object[] iterator) {

        return !isEmpty(iterator);
    }
}
