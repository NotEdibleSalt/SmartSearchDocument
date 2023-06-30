package com.smartsearchdocument.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

/**
 * @author NotEdibleSalt
 */
@Configuration
public class MyJdbcConfiguration extends AbstractJdbcConfiguration {

    @Override
    protected List<?> userConverters() {
        return Arrays.asList(new BooleanToIntConverter(), new IntToBooleanConverter());
    }

    @ReadingConverter
    public class IntToBooleanConverter implements Converter<Integer, Boolean> {

        @Override
        public Boolean convert(Integer source) {

            return source != 0;
        }
    }

    @WritingConverter
    public class BooleanToIntConverter implements Converter<Boolean, Integer> {

        @Override
        public Integer convert(Boolean source) {

            return source ? 1 : 0;
        }
    }
}
