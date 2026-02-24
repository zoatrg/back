package com.app.candm.mybatis.converter;

import com.app.candm.common.enumeration.FileContentType;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class StringToFileContentTypeConverter implements Converter<String, FileContentType>{
    @Override
    public FileContentType convert(String source) {
        return FileContentType.getFileContentType(source);
    }
}
