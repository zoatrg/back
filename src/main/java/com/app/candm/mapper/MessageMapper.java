package com.app.candm.mapper;

import com.app.candm.dto.message.MessageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    // 작성
    public void insert (MessageDTO messageDTO);

}
