package com.app.candm.mapper;

import com.app.candm.dto.message.MessageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    // 작성
    public void insert (MessageDTO messageDTO);

    // 목록 (특정 방의 메시지 전부)
    public List<MessageDTO> selectAllByMessageRoomId(Long messageRoomId);

    // 상세 (메시지 하나)
    public MessageDTO selectById(Long id);
}
