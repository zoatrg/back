package com.app.candm.mapper;

import com.app.candm.dto.message.MessageDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {
    // 작성
    public void insert (MessageDTO messageDTO);

    //목록

    //상세
}
