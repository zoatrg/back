package com.app.candm.mybatis.converter;

import com.app.candm.common.enumeration.Provider;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToStatusProvider implements Converter<String, Provider> {
    @Override
    public Provider convert(String source) {
        return Provider.getProvider(source);
    }
}
